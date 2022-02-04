package ece325_lab_assignment3;

import java.util.ArrayList;

public class EquipmentInventory {
	// your inventory of items
	// create instances of inventory, missing, and needsWrapping arrays
	ArrayList<InventoryItem> inventory;
	ArrayList<InventoryItem> missing;
	ArrayList<InventoryItem> needsWrapping;

	// constructor method
	public EquipmentInventory() {
		inventory = new ArrayList<InventoryItem>();
		missing = new ArrayList<InventoryItem>();
		needsWrapping = new ArrayList<InventoryItem>();
	}

	/**
	 * Stow equipment into the trunk of the bus. Note: every type of equipment
	 * should only occur once in the inventory. Make sure to check if you are not
	 * accidentally taking someone else's equipment.
	 * 
	 * @param equip  The type of equipment to stow
	 * @param number The number of items to stow
	 */
	public void addEquipmentToBus(Equipment equip, int number) {
		for (int i = 0; i < inventory.size(); i++) {
			// if the equip object is equal to the equipment object in inventory
			if (equip.equals(inventory.get(i).getEquipment())) {
				// can only add the number of equipments in the inventory to the bus, not more 
				if (number > inventory.get(i).getInInventory()) {
					number = inventory.get(i).getInInventory();
				}
				// set the InBus value to the previous value + number added
				inventory.get(i).setInBus(number + inventory.get(i).getInBus());
				break;
			// else if equipment type not in inventory, cannot add it to bus
			} else if (i == inventory.size() - 1) {
				System.out.println("Equipment type " + equip.toString() + 
						" is not in inventory and cannot be added to bus.");
			}
		}
	}

	/**
	 * Add equipment to your inventory. Note: every type of equipment
	 * should only occur once in the inventory. Whenever you acquire new
	 * equipment, it is always outside the bus. 
	 * 
	 * @param equip  The type of equipment to add to your inventory
	 * @param number The number of items to add
	 */
	public void addEquipmentToInventory(Equipment equip, int number) {
		if (!inventory.contains(equip)) {
			inventory.add(new InventoryItem(equip, number));
		}
	}

	
	/**
	 * Returns a list of items that are still missing from the bus. 
	 * @return List of missing items.
	 */
	public ArrayList<InventoryItem> getMissingItems() {
		for (int i = 0; i < inventory.size(); i++) {
			// if the amount in inventory != amount in bus and the equipment is not already in missing
			// add the equipment to missing list
			if ((inventory.get(i).getInInventory() != inventory.get(i).getInBus()) && !(missing.contains(inventory.get(i)))) {
				missing.add(inventory.get(i));
			// else if the amount in inventory = amount in bus and the equipment is in missing
			// remove the equipment from missing list
			} else if ((inventory.get(i).getInInventory() == inventory.get(i).getInBus()) 
					&& (missing.contains(inventory.get(i)))){
				missing.remove(inventory.get(i));
			}
		}
		return missing;
	}

	/**
	 * Returns a list of items that still need wrapping. Note that these items might still 
	 * be (partially) missing from the bus too. 
	 * @return List of items that still need to be wrapped.
	 */
	public ArrayList<InventoryItem> getNeedsWrappingItems() {
		for (int i = 0; i < inventory.size(); i++) {
			// if equipment is not wrapped and equipment not in needsWrapping
			// add the equipment to needsWrapping list
			if (inventory.get(i).getEquipment().getNeedsWrapping() && !(needsWrapping.contains(inventory.get(i)))) {
				needsWrapping.add(inventory.get(i));
			// else if equipment is wrapped and equipment in needsWrapping
			// remove the equipment from needsWraping list
			} else if (!(inventory.get(i).getEquipment().getNeedsWrapping()) 
					&& (needsWrapping.contains(inventory.get(i)))){
				needsWrapping.remove(inventory.get(i));
			}
		}
		return needsWrapping;
	}

	/**
	 * Wrap items of the same type as e.
	 * @param The type of equipment you want to wrap. 
	 */
	public void wrapItems(Equipment e) {
		for (int i = 0; i < inventory.size(); i++) {
			// if equipment is in inventory, wrap it
			if (e.equals(inventory.get(i).getEquipment())) {
				inventory.get(i).wrap();
				break;
			// else if equipment is not in inventory, display message
			} else if (i == inventory.size() - 1) {
				System.out.println("Equipment type " + e.toString() + 
						" is not in inventory and cannot be wrapped.");
			}
		}
	}

	/** 
	 * Returns a string representation of the inventory.
	 */
	public String toString() {
		// create formatted string with Equipment name and Quantity of each
		String inventoryString = "";
		inventoryString += "Inventory:\n";
		for (InventoryItem item : inventory) {
			inventoryString += "\tEquipment: " + item.getEquipment().toString() 
					+ "  Quantity: " + String.valueOf(item.getInInventory()) + "\n";
		}
		inventoryString += "\n";
		return inventoryString;
	}

	/** 
	 * Returns true iff the inventory is complete, wrapped and you are ready to go.
	 * @return true iff inventory is complete and wrapped
	 */
	public boolean getReadyToGo() {
		boolean readyToGo = false;
		ArrayList<InventoryItem> missing = getMissingItems();
		ArrayList<InventoryItem> needsWrapping = getNeedsWrappingItems();
		// if both missing and needsWrapping have no values left, we are ready to go
		if (missing.size() == 0 && needsWrapping.size() == 0) {
			readyToGo = true;
		}
		return readyToGo;
	}

	public static void main(String[] args) {
		
		EquipmentInventory myInv = new EquipmentInventory();
		
		//Add 2 microphones, 4 guitars and 12 chairs to Equipment Inventory
		
		Equipment microphone = new Microphone(true);
		myInv.addEquipmentToInventory(microphone, 2);
		
		Equipment guitar = new Guitar(true);
		myInv.addEquipmentToInventory(guitar, 4);
		
		Equipment chair = new Chair(false);
		myInv.addEquipmentToInventory(chair, 12);
		
		// Print inventory
		System.out.println(myInv);

		System.out.println("Printing missing items: ");
		ArrayList<InventoryItem> missing = myInv.getMissingItems();
		System.out.println(missing);

		System.out.println("Printing items that need wrapping: ");
		ArrayList<InventoryItem> needsWrapping = myInv.getNeedsWrappingItems();
		System.out.println(needsWrapping);
		
		//Try to add 15 chairs to bus
		System.out.println("Try to add 15 chairs to bus.");
		myInv.addEquipmentToBus(chair, 15);
		
		// Print inventory
		System.out.println(myInv);

		System.out.println("Ready to go?");
		System.out.println(myInv.getReadyToGo());
		
		//Try to add 4 guitars and 2 microphones to bus
		System.out.println("Try to add 2 microhones and 4 guitars to the bus.");
		myInv.addEquipmentToBus(microphone, 2);
		myInv.addEquipmentToBus(guitar, 4);
		
		System.out.println("Ready to go?");
		System.out.println(myInv.getReadyToGo());

		//Wrap items that need wrapping but have not been wrapped yet
		System.out.println("Wrap remaining unwrapped items.");
		ArrayList<InventoryItem> toWrap = myInv.getNeedsWrappingItems();
		for (int i = 0; i < toWrap.size(); i++) {
			myInv.wrapItems(toWrap.get(i).getEquipment());
		}

		System.out.println("Ready to go?");
		System.out.println(myInv.getReadyToGo());
		
	}
}
