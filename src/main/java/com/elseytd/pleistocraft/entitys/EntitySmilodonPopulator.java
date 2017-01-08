package com.elseytd.pleistocraft.entitys;

import com.elseytd.pleistocraft.registries.ItemsRegistry;
import com.elseytd.pleistocraft.utils.Tools;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class EntitySmilodonPopulator extends EntityTameable {

    private float headRotationCourse;
    private float headRotationCourseOld;
    private boolean isWet;
    private boolean isShaking;
    private float timeWolfIsShaking;
    private float prevTimeWolfIsShaking;
    private int mode = 0;//0 - move freely, 1 - follow, 2-stay
    private boolean issaddled;
    private static final DataParameter<Boolean> BEGGING = EntityDataManager.<Boolean>createKey(EntityWolf.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.<Float>createKey(EntityWolf.class, DataSerializers.FLOAT);
    private static final DataParameter<Integer> COLLAR_COLOR = EntityDataManager.<Integer>createKey(EntityWolf.class, DataSerializers.VARINT);

    public EntitySmilodonPopulator(World worldIn) {
        super(worldIn);
        if (this.isChild()) {
            this.setSize(1.5F, 0.8F);
        } else {
            this.setSize(0.8F, 1.6F);
        }
        int i = 0;
//      ((PathNavigateGround) this.getNavigator()).setAvoidsWater(true);
        this.tasks.addTask(i++, new EntityAISwimming(this));
        this.tasks.addTask(i++, this.aiSit);
        this.tasks.addTask(i++, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(i++, new EntityAILeapAtTarget(this, 0.4F));
    //      this.tasks.addTask(i++, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(i++, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(i++, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(i++, new EntityAIWatchClosest(this, EntityPlayer.class, 12.0F));
        this.tasks.addTask(i++, new EntityAILookIdle(this));
       i = 0;
        this.targetTasks.addTask(i++, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(i++, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(i++, new EntityAIHurtByTarget(this, true, new Class[0]));

        this.setTamed(false);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(50.3D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(5.0D);
    }

    @Override
    protected Item getDropItem() {
        return ItemsRegistry.smilodon_populator_skull;
    }

    @Override
    public EntitySmilodonPopulator createChild(EntityAgeable ageable) {
        return new EntitySmilodonPopulator(this.worldObj);
    }

    @Override
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        int i = Tools.randint(0, 2);

        for (int k = 0; k < i; ++k) {
            this.dropItem(Items.BONE, 1);
        }

        i = Tools.randint(1, 3);

        for (int k = 0; k < i; ++k) {
            if (this.isBurning()) {
                this.dropItem(ItemsRegistry.cooked_smilodon_meat, 1);
            } else {
                this.dropItem(ItemsRegistry.raw_smilodon_meat, 1);
            }
        }

        i = Tools.randint(0, 1);

        for (int k = 0; k < i; ++k) {
            this.dropItem(ItemsRegistry.smilodon_populator_skull, 1);
        }
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow,
     * gets into the saddle on a pig.
     *
     * @param player
     * @return
     */
    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand, @Nullable ItemStack itemStack) {
        ItemStack itemstack = player.inventory.getCurrentItem();
        if (!player.isSneaking()) {
            if (this.isTamed()) {
                if (itemstack != null) {
                    if (itemstack.getItem() instanceof ItemFood) {
                        ItemFood itemfood = (ItemFood) itemstack.getItem();

                        if (itemfood.isWolfsFavoriteMeat() &&
                                //this.dataWatcherList.getWatchableObjectFloat(18) < 30.0F) {
                        this.dataManager.get(DATA_HEALTH_ID) < 30.0F) {
                            if (itemstack != new ItemStack(Items.ROTTEN_FLESH) && itemstack != new ItemStack(ItemsRegistry.raw_smilodon_meat) && itemstack != new ItemStack(ItemsRegistry.cooked_smilodon_meat)) {
                                if (!player.capabilities.isCreativeMode) {
                                    --itemstack.stackSize;
                                }

                                this.heal(3);

                                if (itemstack.stackSize <= 0) {
                                    player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
                                }
                            }
                            return true;
                        }
                    } else if (itemstack.getItem() == Items.SADDLE) {
                        if (!this.worldObj.isRemote && !this.isSaddled()) {
                            this.addSaddle();
                        }
                    }
                } else if (this.worldObj.isRemote || !(this.isRidingOrBeingRiddenBy(player)) && !(this.isRidingOrBeingRiddenBy(null))) {

                } else {
                    if (!this.isChild() && this.isSaddled()) {
                        this.mountTo(player);
                        return true;
                    }
                }

                if (this.isOwner(player) && !this.worldObj.isRemote && !this.isBreedingItem(itemstack)) {
                    this.aiSit.setSitting(!this.isSitting());
                    this.isJumping = false;
                    this.navigator.clearPathEntity();
                    this.setAttackTarget((EntityLivingBase) null);
                }
            } else if (itemstack != null && itemstack.getItem() == Items.BEEF && !this.isAngry()) {
                if (!player.capabilities.isCreativeMode) {
                    --itemstack.stackSize;
                }

                if (itemstack.stackSize <= 0) {
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
                }

                if (!this.worldObj.isRemote) {
                    if (this.rand.nextInt(4) == 0) {
                        this.setTamed(true);
                        this.navigator.clearPathEntity();
                        this.setAttackTarget((EntityLivingBase) null);
                        this.setHealth(40.0F);
                        this.setOwnerId(player.getUniqueID());
                        this.playTameEffect(true);
                        this.worldObj.setEntityState(this, (byte) 7);
                    } else {
                        this.playTameEffect(false);
                        this.worldObj.setEntityState(this, (byte) 6);
                    }
                }

                return true;
            }
        } else {
            if (!this.worldObj.isRemote && this.isTamed()) {
                switch (mode) {
                    case 0:
                        player.addChatMessage(new TextComponentString(ChatFormatting.GOLD + "Set to 'follow' mode."));
                        this.aiSit.setSitting(false);
                        mode = 1;
                        break;
                    case 1:
                        player.addChatMessage(new TextComponentString(ChatFormatting.GOLD + "Set to 'stay' mode."));
                        this.aiSit.setSitting(true);
                        mode = 2;
                        break;
                    case 2:
                        player.addChatMessage(new TextComponentString(ChatFormatting.GOLD + "Set to 'move freely' mode."));
                        this.aiSit.setSitting(false);
                        mode = 0;
                        break;
                }
            }
        }
        return super.processInteract(player, hand, itemStack);
    }

    private void mountTo(EntityPlayer player)
    {
        player.rotationYaw = this.rotationYaw;
        player.rotationPitch = this.rotationPitch;

        if (!this.worldObj.isRemote)
        {
            player.startRiding(this);
        }
    }


    public boolean isSaddled(){
        return this.issaddled;
    }
    
    public void addSaddle(){
        this.issaddled = true;
    }
    
    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     *
     * @param tagCompound
     */
    @Override
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setBoolean("SMILODON.Angry", this.isAngry());
        tagCompound.setInteger("SMILODON.Mode", this.mode);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     *
     * @param tagCompund
     */
    @Override
    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        this.setAngry(tagCompund.getBoolean("SMILODON.Angry"));
        this.setmode(tagCompund.getInteger("SMILODON.Mode"));
    }

    public void setmode(int i) {
        this.mode = i;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     *
     * @return
     */
    /*
    @Override
    protected SoundEvent getLivingSound() {
        return null;
    }
*/
    /**
     * Returns the sound this mob makes when it is hurt.
     *
     * @return
     */
    @Override
    protected SoundEvent getHurtSound() {
        return SoundEvents.ENTITY_WOLF_HURT;
    }

    /**
     * Returns the sound this mob makes on death.
     *
     * @return
     */
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WOLF_DEATH;
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = entityIn.attackEntityFrom(
                DamageSource.causeMobDamage(this),
                (float) ((int) this.getEntityAttribute(
                        SharedMonsterAttributes.ATTACK_DAMAGE)
                .getAttributeValue()));

        if (flag) {
            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }

    /**
     * Sets the active target the Task system uses for tracking
     *
     * @param entitylivingbaseIn
     */
    @Override
    public void setAttackTarget(EntityLivingBase entitylivingbaseIn) {
        super.setAttackTarget(entitylivingbaseIn);

        if (entitylivingbaseIn == null) {
            this.setAngry(false);
        } else if (!this.isTamed() && !this.isChild()) {
            this.setAngry(true);
        } else {
            this.setAngry(false);
            this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
        }
    }

    @Override
    protected void updateAITasks() {
        //this.dataWatcher.update(18, this.getHealth());
        this.dataManager.register(DATA_HEALTH_ID, Float.valueOf(this.getHealth()));
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        //this.dataWatcher.addObject(18, this.getHealth());
        this.dataManager.register(DATA_HEALTH_ID, Float.valueOf(this.getHealth()));
        this.dataManager.register(BEGGING, Boolean.valueOf(false));
        this.dataManager.register(COLLAR_COLOR, Integer.valueOf(EnumDyeColor.RED.getDyeDamage()));
        //this.dataWatcher.addObject(19, (byte) 0);
        //this.dataWatcher.addObject(20, (byte) EnumDyeColor.RED.getMetadata());
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F);
    }

    /**
     * Returns the volume for the sounds this mob makes.
     *
     * @return
     */
    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    /**
     * Called frequently so the entity can update its state every tick as
     * required. For example, zombies and skeletons use this to react to
     * sunlight and start to burn.
     */
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.mode == 2) {
            this.aiSit.setSitting(true);
        } else {
            this.aiSit.setSitting(false);
        }

        if (!this.worldObj.isRemote && this.isWet && !this.isShaking && !this.hasPath() && this.onGround) {
            this.isShaking = true;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
            this.worldObj.setEntityState(this, (byte) 8);
        }

        if (!this.worldObj.isRemote && this.getAttackTarget() == null && this.isAngry()) {
            this.setAngry(false);
        }
        if (!this.worldObj.isRemote && this.isAngry()) {
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
            this.setSprinting(isSprinting());
        } else if (!this.worldObj.isRemote && !this.isAngry()) {
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
            this.setSprinting(isSprinting());
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        super.onUpdate();
        this.headRotationCourseOld = this.headRotationCourse;

        if (this.isBegging()) {
            this.headRotationCourse += (1.0F - this.headRotationCourse) * 0.4F;
        } else {
            this.headRotationCourse += (0.0F - this.headRotationCourse) * 0.4F;
        }

        if (this.isWet()) {
            this.isWet = true;
            this.isShaking = false;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
        } else if ((this.isWet || this.isShaking) && this.isShaking) {
            if (this.timeWolfIsShaking == 0.0F) {
                this.playSound(SoundEvents.ENTITY_WOLF_SHAKE, this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            }

            this.prevTimeWolfIsShaking = this.timeWolfIsShaking;
            this.timeWolfIsShaking += 0.05F;

            if (this.prevTimeWolfIsShaking >= 2.0F) {
                this.isWet = false;
                this.isShaking = false;
                this.prevTimeWolfIsShaking = 0.0F;
                this.timeWolfIsShaking = 0.0F;
            }

            if (this.timeWolfIsShaking > 0.4F) {
                float f = (float) this.getEntityBoundingBox().minY;
                int i = (int) (MathHelper.sin((this.timeWolfIsShaking - 0.4F)
                        * (float) Math.PI) * 7.0F);

                for (int j = 0; j < i; ++j) {
                    float f1 = (this.rand.nextFloat() * 2.0F - 1.0F)
                            * this.width * 0.5F;
                    float f2 = (this.rand.nextFloat() * 2.0F - 1.0F)
                            * this.width * 0.5F;
                    this.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH,
                            this.posX + (double) f1, (double) (f + 0.8F),
                            this.posZ + (double) f2, this.motionX,
                            this.motionY, this.motionZ, new int[0]);
                }
            }
        }
    }

    /**
     * True if the wolf is wet
     *
     * @return
     */
    @SideOnly(Side.CLIENT)
    public boolean isWolfWet() {
        return this.isWet;
    }

    /**
     * Used when calculating the amount of shading to apply while the wolf is
     * wet.
     *
     * @param f
     * @return
     */
    @SideOnly(Side.CLIENT)
    public float getShadingWhileWet(float f) {
        return 0.75F + (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * f) / 2.0F * 0.25F;
    }

    @SideOnly(Side.CLIENT)
    public float getShakeAngle(float p_70923_1_, float p_70923_2_) {
        float f = (this.prevTimeWolfIsShaking
                + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking)
                * p_70923_1_ + p_70923_2_) / 1.8F;

        if (f < 0.0F) {
            f = 0.0F;
        } else if (f > 1.0F) {
            f = 1.0F;
        }

        return MathHelper.sin(f * (float) Math.PI)
                * MathHelper.sin(f * (float) Math.PI * 11.0F) * 0.15F
                * (float) Math.PI;
    }

    @SideOnly(Side.CLIENT)
    public float getInterestedAngle(float p_70917_1_) {
        return (this.headRotationCourseOld + (this.headRotationCourse - this.headRotationCourseOld)
                * p_70917_1_)
                * 0.15F * (float) Math.PI;
    }

    @Override
    public float getEyeHeight() {
        return this.height * 0.8F;
    }

    /**
     * The speed it takes to move the entityliving's rotationPitch through the
     * faceEntity method. This is only currently use in wolves.
     *
     * @return
     */
    @Override
    public int getVerticalFaceSpeed() {
        return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
    }

    /**
     * Called when the entity is attacked.
     *
     * @param source
     * @param amount
     * @return
     */
    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable(source)) {
            return false;
        } else {
            Entity entity = source.getEntity();
            this.aiSit.setSitting(false);

            if (entity != null && !(entity instanceof EntityPlayer)
                    && !(entity instanceof EntityArrow)) {
                amount = (amount + 1.0F) / 2.0F;
            }

            return super.attackEntityFrom(source, amount);
        }
    }

    @Override
    public void setTamed(boolean tamed) {
        super.setTamed(tamed);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(50.3D);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void handleStatusUpdate(byte id) {
        if (id == 8) {
            this.isShaking = true;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
        } else {
            super.handleStatusUpdate(id);
        }
    }

    @SideOnly(Side.CLIENT)
    public float getTailRotation() {
        return this.isAngry() ? 1.5393804F : (this.isTamed() ? (0.55F - (20.0F - this.dataManager.get(DATA_HEALTH_ID).floatValue() * 0.02F)) * (float) Math.PI : ((float) Math.PI / 5F));
        //getWatchableObjectFloat(18)) * 0.02F) * (float) Math.PI : ((float) Math.PI / 5F));
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed
     * it (wheat, carrots or seeds depending on the animal type)
     *
     * @param stack
     * @return
     */
    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack == null ? false
                : (!(stack.getItem() instanceof ItemFood) ? false
                        : ((ItemFood) stack.getItem()).isWolfsFavoriteMeat());
    }

    /**
     * Will return how many at most can spawn in a chunk at once.
     *
     * @return
     */
    @Override
    public int getMaxSpawnedInChunk() {
        return 8;
    }

    /**
     * Determines whether this wolf is angry or not.
     *
     * @return
     */
    public boolean isAngry() {
        //return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
        return (((Byte)this.dataManager.get(TAMED)).byteValue() & 2) != 0;
    }

    /**
     * Sets whether this wolf is angry or not.
     *
     * @param angry
     */
    public void setAngry(boolean angry) {
        //byte b0 = this.dataManager.getWatchableObjectByte(16);
        byte b0 = this.dataManager.get(TAMED);

        if (angry) {
            //this.dataWatcher.updateObject(16, (byte) (b0 | 2));
            this.dataManager.set(TAMED, Byte.valueOf((byte)(b0 | 2)));
        } else {
            this.dataManager.set(TAMED, Byte.valueOf((byte)(b0 & -3)));
            //this.dataWatcher.updateObject(16, (byte) (b0 & -3));
        }
    }

    public EnumDyeColor getCollarColor() {
        //return EnumDyeColor.byDyeDamage(this.dataWatcher.getWatchableObjectByte(20) & 15);
        return EnumDyeColor.byDyeDamage(this.dataManager.get(COLLAR_COLOR).intValue() & 15);
    }

    public void setCollarColor(EnumDyeColor collarcolor) {
        //this.dataWatcher.updateObject(20, (byte) (collarcolor.getDyeDamage() & 15));
        this.dataManager.set(COLLAR_COLOR, Integer.valueOf(collarcolor.getDyeDamage()));
    }

    public void setBegging(boolean beg) {
        if (beg) {
            //this.dataWatcher.updateObject(19, (byte) 1);
            this.dataManager.set(BEGGING, Boolean.valueOf(true));
        } else {
            //this.dataWatcher.updateObject(19, (byte) 0);
            this.dataManager.set(BEGGING, Boolean.valueOf(false));
        }
    }

    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     *
     * @param otherAnimal
     * @return
     */
    @Override
    public boolean canMateWith(EntityAnimal otherAnimal) {
        if (otherAnimal == this) {
            return false;
        } else if (!(otherAnimal instanceof EntitySmilodonPopulator)) {
            return false;
        } else {
            EntitySmilodonPopulator entitywolf = (EntitySmilodonPopulator) otherAnimal;
            return this.isInLove() && entitywolf.isInLove();
        }
    }

    public boolean isBegging() {
        //return this.dataManager.getWatchableObjectByte(19) == 1;
        return ((Boolean)this.dataManager.get(BEGGING)).booleanValue();
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     *
     * @return
     */
    @Override
    protected boolean canDespawn() {
        return !this.isTamed() && this.ticksExisted > 2400;
    }

    @Override
    public boolean shouldAttackEntity(EntityLivingBase attacked, EntityLivingBase attacker) {
        if (!(attacked instanceof EntityCreeper) && !(attacked instanceof EntityGhast)) {
            if (attacked instanceof EntityWolf) {
                EntityWolf entitywolf = (EntityWolf) attacked;

                if (entitywolf.isTamed() && entitywolf.getOwner() == attacker) {
                    return false;
                }
            }
            return attacked instanceof EntityPlayer && attacker instanceof EntityPlayer && !((EntityPlayer) attacker).canAttackPlayer((EntityPlayer) attacked) ? false : !(attacked instanceof EntityHorse) || !((EntityHorse) attacked).isTame();
        } else {
            return false;
        }
    }

    @Override
    public boolean canBeLeashedTo(EntityPlayer player) {
        return !this.isAngry() && super.canBeLeashedTo(player);
    }

    /**
     * Moves the entity based on the specified heading. Args: strafe, forward
     *
     * @param strafe
     * @param forward
     */
    @Override
    public void moveEntityWithHeading(float strafe, float forward) {
        if (this.getRidingEntity() != null && this.getRidingEntity() instanceof EntityLivingBase) {
            this.prevRotationYaw = this.rotationYaw = this.getRidingEntity().rotationYaw;
            this.rotationPitch = this.getRidingEntity().rotationPitch * 0.5F;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
            strafe = ((EntityLivingBase) this.getRidingEntity()).moveStrafing * 0.5F;
            forward = ((EntityLivingBase) this.getRidingEntity()).moveForward;

            if (forward <= 0.0F) {
                forward *= 0.25F;
            }

            this.stepHeight = 1.0F;
            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

            if (!this.worldObj.isRemote) {
                this.setAIMoveSpeed((float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
                super.moveEntityWithHeading(strafe, forward);
            }

            this.prevLimbSwingAmount = this.limbSwingAmount;
            double d1 = this.posX - this.prevPosX;
            double d0 = this.posZ - this.prevPosZ;
            float f2 = MathHelper.sqrt_double(d1 * d1 + d0 * d0) * 4.0F;

            if (f2 > 1.0F) {
                f2 = 1.0F;
            }

            this.limbSwingAmount += (f2 - this.limbSwingAmount) * 0.4F;
            this.limbSwing += this.limbSwingAmount;
        } else {
            this.stepHeight = 0.5F;
            this.jumpMovementFactor = 0.02F;
            super.moveEntityWithHeading(strafe, forward);
        }
    }

}
