package CHARACTER;

import ITEM.*;

public class Player extends Character
{
 
    private Item weapon  = null;
    private Item armor = null;

//-------------------------------------------

    //Constructor
    public Player(String name, int maxhp, int atk, int def, int range, int x, int y)
    {
        super(name, maxhp, atk, def, range, x, y);
    }


    @Override
    public String getMark()
    {return "X";}

    //Show state of player
    public void showState()
    {
        System.out.println("HP: " + this.getHP() + " / " + this.getMaxHp());
        System.out.println("Attack: " + this.getAttack());
        System.out.println("Defense: " + this.getDefense());
        System.out.println("Range: " + this.getRange());
        System.out.println("Current Weapon: " + (weapon != null ? weapon.getName() : "None"));
        System.out.println("Current Armor: " + (armor != null ? armor.getName() : "None"));
    }


    
    //How to unequip attack weapon from player
    public void unequipWeapon()
    {
        if(this.weapon != null)
        {
            //Remove current attack weapon (if exist) with its effect
            this.weapon.unapplyEffectTo(this);
            this.weapon = null;
        }
    }

    //How to unequip defensive weapon from player
    public void unequipArmor()
    {
        if(this.armor != null)
        {
            //Remove current defensive weapon (if exist) with its effect
            this.armor.unapplyEffectTo(this);       
            this.armor = null;
        }
    }


    //How to equip somewhat weapon to player
    public void equipItem(Item itemToEquip)
    {
        //Check if the item to equip is attack or defensive kind
        boolean isWeapon = true;
        if(itemToEquip.getType() == 3)
        {
            isWeapon = false;
        }

        //Equip the weapon to corresponding type 
        if(isWeapon == true)
        {
            //1. Remove current attack weapon with corresponding effect
            this.unequipWeapon();

            //2. Equip new attack weapon with corresponding effect
            this.weapon = itemToEquip;
            this.weapon.applyEffectTo(this);
        }
        else
        {
            //1. Remove current defensive weapon with corresponding effect
            this.unequipArmor();

            //2. Equip new defensive weapon with corresponding effect
            this.armor = itemToEquip;
            this.armor.applyEffectTo(this);   
        }
    }
    

    public void equipWeapon(Item itemToEquip)
    {
        //Identify which type of item
        boolean isWeapon = false;
        if(itemToEquip.getType() == 1)
        {
            isWeapon = true;
        }

        //Equip Item
        if(!isWeapon)
        {
            System.out.println("ERROR: Invalid Item To Equip");
        }
        else
        {
             //1. Remove current attack weapon with corresponding effect
             this.unequipWeapon();

             //2. Equip new attack weapon with corresponding effect
             this.weapon = itemToEquip;
             this.weapon.applyEffectTo(this);           
        }
    } 


    public void equipArmor(Item itemToEquip)
    {
        //Identify which type of item
        boolean isArmor = false;
        if(itemToEquip.getType() == 2)
        {
            isArmor = true;
        }

        //Equip Item
        if(!isArmor)
        {
            System.out.println("ERROR: Invalid Item To Equip");
        }
        else
        {
             //1. Remove current attack weapon with corresponding effect
             this.unequipArmor();

             //2. Equip new attack weapon with corresponding effect
             this.armor = itemToEquip;
             this.armor.applyEffectTo(this);           
        }
    } 


    public static void main(String[] args) 
    {
         
      
    }


    
}

