# text-adventure

## Items and Commands.
First Room: Sword, Lantern, Scoll, Iron Key
Second Room: Rusty Key

Go (direction)
Talk (npc)

Get (item)

Drop (item)

Inventory

Attack

Flee

## To-do's.

1. Create save slots, descriptions for each slot, and describe what the user will see.
1. Load map from data structure.
1. Update room class to support multi-floor levels. Includes adding ceiling and floor classes.
1. Update character class to allow user to equip items.
1. Update character class to support levels. 
1. Adding support for currency. 


##Combat system:

Flee: Roll d20, if 9< you run away. If 10> you fail to run away, and monster takes turn.

Use Item: You use an item, and the monster does not take a turn.

Attack: Roll d20 to see if you hit the monster. If 10 or above, you hit. If 9 or below, you miss. When you hit, roll d6 to calculate damage. Monster does the same thing. When HP reaches 0, you die. Different weapons would have different dice damage. 

Different armors would increase your health by x amount. 

When combat is done, your health doesn't replenish itself. You have to use either a potion or find a spring of healing to regain HP.
