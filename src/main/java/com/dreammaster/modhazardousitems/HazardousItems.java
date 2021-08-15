
package com.dreammaster.modhazardousitems;


import com.dreammaster.modhazardousitems.cause.HazardCause;
import eu.usrv.yamcore.auxiliary.FluidHelper;
import eu.usrv.yamcore.auxiliary.ItemDescriptor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


@XmlAccessorType( XmlAccessType.FIELD )
@XmlRootElement( name = "HazardousItemList" )
public class HazardousItems
{

  @XmlElement( name = "Item" )
  protected List<HazardousItem> hazardousItem;

  @XmlElement( name = "Fluid" )
  protected List<HazardousFluid> hazardousFluid;

  public List<HazardousFluid> getHazardousFluids()
  {
    if( hazardousFluid == null ) {
        hazardousFluid = new ArrayList<>();
    }

    return hazardousFluid;
  }

  public List<HazardousItem> getHazardousItems()
  {
    if( hazardousItem == null ) {
        hazardousItem = new ArrayList<>();
    }

    return hazardousItem;
  }

  /**
   * Find HazardousFluid by exact name (case sensitive)
   * 
   * @param pFluidName
   * @return
   */
  public HazardousFluid FindHazardousFluidExact( String pFluidName )
  {
    for( HazardousFluid hf : hazardousFluid )
    {
      if( hf.fluidName.equals( pFluidName ) ) {
          return hf;
      }
    }

    return null;
  }

  /**
   * Find HazardousItem by exact Itemname (case sensitive)
   * 
   * @param pItemName
   * @return
   */
  public HazardousItem FindHazardousItemExact( String pItemName )
  {
    for( HazardousItem hi : hazardousItem )
    {
      if( hi.itemName.equals( pItemName ) ) {
          return hi;
      }
    }

    return null;
  }

  /**
   * Remove item from list
   * 
   * @param pInHand
   * @return
   */
  public boolean RemoveItemExact( ItemStack pInHand, boolean pIncludeNonExact )
  {
    try
    {
      List<HazardousItem> tNewList = new ArrayList<>();

      for( HazardousItem hi : hazardousItem )
      {
        if( hi.exactMatch )
        {
          // Exact match
          // if (hi.itemName.equals(pInHand.getUnlocalizedName()))
          if( hi.itemName.equals( ItemDescriptor.fromItem( pInHand.getItem() ) ) ) {
              continue; // Dont read to new list
          }
        }
        else
        {
          if( pIncludeNonExact ) // Only if we include nonExact entries
          {
            // "contains" match
            String p1 = hi.itemName.toLowerCase();
            // String p2 =
            // pInHand.getUnlocalizedName().toLowerCase();
            String p2 = ItemDescriptor.fromItem( pInHand.getItem() ).toString().toLowerCase();

            if( p2.contains( p1 ) ) {
                continue;
            }
          }
        }

        tNewList.add( hi ); // ReAdd entry to new list, as it didn't match with above entries
      }

      hazardousItem = tNewList;
      return true;
    }
    catch( Exception e )
    {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Remove fluid from list
   * 
   * @param pInHand
   * @return
   */
  public boolean RemoveFluidExact( ItemStack pInHand, boolean pIncludeNonExact )
  {
    try
    {
      List<HazardousFluid> tNewList = new ArrayList<>();
      Fluid tContainerFluid = FluidHelper.getFluidFromContainer( pInHand );

      for( HazardousFluid hi : hazardousFluid )
      {
        if( hi.exactMatch )
        {
          // Exact match
          if( hi.fluidName.equals( tContainerFluid.getName() ) ) {
              continue; // Dont read to new list
          }
        }
        else
        {
          if( pIncludeNonExact ) // Only if we include nonExact entries
          {
            // "contains" match
            String p1 = hi.fluidName.toLowerCase();
            String p2 = tContainerFluid.getName().toLowerCase();

            if( p2.contains( p1 ) ) {
                continue;
            }
          }
        }

        tNewList.add( hi ); // ReAdd entry to new list, as it didn't match with above entries
      }

      hazardousFluid = tNewList;
      return true;
    }
    catch( Exception e )
    {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Searches for HazardousItem by text compare, where pSearchString is
   * anywhere inside the items name name. Ex: lava would match bucketLava,
   * tankLava, itemLavaGloves,...
   * 
   * @param pSearchString
   * @return
   */
  public HazardousItem FindHazardousItemContains( String pSearchString, boolean pIgnoreCase )
  {
    for( HazardousItem hi : hazardousItem )
    {
      String p1 = pIgnoreCase ? hi.itemName.toLowerCase() : hi.itemName;
      String p2 = pIgnoreCase ? pSearchString.toLowerCase() : pSearchString;

      if( p1.contains( p2 ) ) {
          return hi;
      }
    }

    return null;
  }

  /**
   * Searches for HazardousFluids by text compare, where pSearchString is
   * anywhere inside the items name name. Ex: lava would match bucketLava,
   * tankLava, itemLavaGloves,...
   * 
   * @param pSearchString
   * @return
   */
  public HazardousFluid FindHazardousFluidContains( String pSearchString, boolean pIgnoreCase )
  {
    for( HazardousFluid hi : hazardousFluid )
    {
      String p1 = pIgnoreCase ? hi.fluidName.toLowerCase()
          : hi.fluidName;
      String p2 = pIgnoreCase ? pSearchString.toLowerCase()
          : pSearchString;

      if( p1.contains( p2 ) ) {
          return hi;
      }
    }

    return null;
  }

  /**
   * Find HazardousItem by using ItemStack reference
   * 
   * @param pItemStack
   * @return
   */
  public HazardousItem FindHazardousItem( ItemStack pItemStack )
  {
    for( HazardousItem hi : hazardousItem )
    {
      if( hi.exactMatch )
      {
        // Exact match
        // if (hi.itemName.equals(pItemStack.getUnlocalizedName()))
        if( hi.itemName.equals( ItemDescriptor.fromStack( pItemStack )
            .toString() ) ) {
            return hi;
        }
      }
      else
      {
        // "contains" match
        String p1 = hi.itemName.toLowerCase();
        // String p2 = pItemStack.getUnlocalizedName().toLowerCase();
        String p2 = ItemDescriptor.fromStack( pItemStack ).toString()
            .toLowerCase();

        if( p2.contains( p1 ) ) {
            return hi;
        }
      }
    }

    return null;
  }

  /**
   * Find HazardousFluid by using ItemStack reference
   * 
   * @param pItemStack
   * @return
   */
  public HazardousFluid FindHazardousFluid( ItemStack pItemStack )
  {
    FluidStack tStackFluid = FluidHelper.getFluidStackFromContainer( pItemStack );
    if( tStackFluid == null ) {
        return null;
    }

    if( tStackFluid.amount == 0 ) {
        return null;
    }

    for( HazardousFluid hi : hazardousFluid )
    {
      if( hi.exactMatch )
      {
        // Exact match
        if( hi.fluidName.equals( tStackFluid.getFluid().getName() ) ) {
            return hi;
        }
      }
      else
      {
        // "contains" match
        String p1 = hi.fluidName.toLowerCase();
        String p2 = tStackFluid.getFluid().getName().toLowerCase();

        if( p2.contains( p1 ) ) {
            return hi;
        }
      }
    }

    return null;
  }

  @XmlAccessorType( XmlAccessType.FIELD )
  @XmlType
  public static class HazardousItem implements IDamageEffectContainer
  {

    @XmlAttribute( name = "ItemName" )
    public String itemName;
    @XmlAttribute( name = "ExactNameMatch" )
    protected boolean exactMatch;

    @XmlAttribute( name = "OnContactCheck" )
    protected boolean checkContact;
    @XmlAttribute( name = "InventoryCheck" )
    protected boolean checkInventory;

    @XmlElement( name = "DamageEffect" )
    protected List<ItmDamageEffect> damageEffect;
    @XmlElement( name = "PotionEffect" )
    protected List<ItmPotionEffect> potionEffect;

    public void setCheckInventory( boolean pVal )
    {
      checkInventory = pVal;
    }

    public void setCheckContact( boolean pVal )
    {
      checkContact = pVal;
    }

    public boolean getCheckInventory()
    {
      return checkInventory;
    }

    public boolean getCheckContact()
    {
      return checkContact;
    }

    public String getItemName()
    {
      return itemName;
    }

    public void setItemName( String value )
    {
        itemName = value;
    }

    public boolean getExactMatch()
    {
      return exactMatch;
    }

    public void setExactMatch( boolean value )
    {
        exactMatch = value;
    }

    @Override
    public List<ItmPotionEffect> getPotionEffects()
    {
      if( potionEffect == null )
      {
        potionEffect = new ArrayList<>();
      }
      return potionEffect;
    }

    @Override
    public List<ItmDamageEffect> getDamageEffects()
    {
      if( damageEffect == null )
      {
        damageEffect = new ArrayList<>();
      }
      return damageEffect;
    }
  }

  @XmlAccessorType( XmlAccessType.FIELD )
  @XmlType
  public static class HazardousFluid implements IDamageEffectContainer
  {

    @XmlAttribute( name = "FluidName" )
    public String fluidName;
    @XmlAttribute( name = "ExactNameMatch" )
    protected boolean exactMatch;

    @XmlAttribute( name = "OnContactCheck" )
    protected boolean checkContact;
    @XmlAttribute( name = "InventoryCheck" )
    protected boolean checkInventory;

    @XmlElement( name = "DamageEffect" )
    protected List<ItmDamageEffect> damageEffect;
    @XmlElement( name = "PotionEffect" )
    protected List<ItmPotionEffect> potionEffect;

    public void setCheckInventory( boolean pVal )
    {
      checkInventory = pVal;
    }

    public void setCheckContact( boolean pVal )
    {
      checkContact = pVal;
    }

    public boolean getCheckInventory()
    {
      return checkInventory;
    }

    public boolean getCheckContact()
    {
      return checkContact;
    }

    public String getFluidName()
    {
      return fluidName;
    }

    public void setFluidName( String value )
    {
        fluidName = value;
    }

    public boolean getExactMatch()
    {
      return exactMatch;
    }

    public void setExactMatch( boolean value )
    {
        exactMatch = value;
    }

    @Override
    public List<ItmPotionEffect> getPotionEffects()
    {
      if( potionEffect == null )
      {
        potionEffect = new ArrayList<>();
      }
      return potionEffect;
    }

    @Override
    public List<ItmDamageEffect> getDamageEffects()
    {
      if( damageEffect == null )
      {
        damageEffect = new ArrayList<>();
      }
      return damageEffect;
    }
  }

  @XmlAccessorType( XmlAccessType.FIELD )
  @XmlType
  public static class ItmDamageEffect extends HazardEffect
  {

    @XmlAttribute( name = "Source" )
    protected String damageSource;
    @XmlAttribute( name = "Amount" )
    protected Float amount;

    public String getDamageSource()
    {
      return damageSource;
    }

    public void setDamageSource( String value )
    {
        damageSource = value;
    }

    public Float getAmount()
    {
      return amount;
    }

    public void setAmount( Float value )
    {
        amount = value;
    }

    @Override
    protected void apply(HazardCause cause, EntityPlayer player) {
      Function<HazardCause, DamageSource> sourceFactory = HazardDamageSources.getDamageSourceFactoryOrFail(getDamageSource());
      player.attackEntityFrom(sourceFactory.apply(cause), getAmount());
    }
  }

  @XmlAccessorType( XmlAccessType.FIELD )
  @XmlType
  public static class ItmPotionEffect extends HazardEffect
  {

    @XmlAttribute( name = "PotionID" )
    protected Integer id;
    @XmlAttribute( name = "TickDuration" )
    protected Integer duration;
    @XmlAttribute( name = "Level" )
    protected Integer level;

    public Integer getId()
    {
      return id;
    }

    public void setId( Integer value )
    {
        id = value;
    }

    public Integer getDuration()
    {
      return duration;
    }

    public void setDuration( Integer value )
    {
        duration = value;
    }

    public Integer getLevel()
    {
      return level;
    }

    public void setLevel( Integer value )
    {
        level = value;
    }

    @Override
    protected void apply(HazardCause cause, EntityPlayer player) {
      player.addPotionEffect(new PotionEffect(getId(), getDuration(), getLevel()));
    }
  }
}
