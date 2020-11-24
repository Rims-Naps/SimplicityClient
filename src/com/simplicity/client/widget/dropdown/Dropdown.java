package com.simplicity.client.widget.dropdown;

import static com.simplicity.Configuration.enableOldFrame;

import com.simplicity.Configuration;
import com.simplicity.client.Client;
import com.simplicity.client.RSInterface;
import com.simplicity.client.content.Keybinding;

public enum Dropdown {
	
	ITEM_STATS() {
		@Override
        public void selectOption(int selected, RSInterface dropdown) {
			if (selected == 0) {
				Configuration.enableItemStats = 2;
			} else if (selected == 1) {
				Configuration.enableItemStats = 1;
			} else if (selected == 2) {
				Configuration.enableItemStats = 0;
			}
        }
	},
	
	GAMEFRAME() {
		@Override
        public void selectOption(int selected, RSInterface dropdown) {
			if (selected != 2) {
				Configuration.enableOldschoolFrame = false;
			}
			
			if (selected == 0) {
				Configuration.enableOldFrame = true;
				
				if (Client.tabID == 13) {
                	Client.tabID = 15;
                }
			} else if (selected == 1) {
				Configuration.enableOldFrame = false;
				
				if (Client.tabID == 15) {
                	Client.tabID = 13;
                }
			} else if (selected == 2) {
				Configuration.enableOldFrame = true;
				Configuration.enableOldschoolFrame = true;
				
				if (Client.tabID == 15) {
                	Client.tabID = 13;
                }
			}
        }
	},

	HITMARKERS() {
		@Override
        public void selectOption(int selected, RSInterface dropdown) {
			if (selected == 0) {
				Configuration.enableOldHitmarkers = false;
			} else if (selected == 1) {
				Configuration.enableOldHitmarkers = true;
			}
        }
	},
	
	HPBARS() {
		@Override
        public void selectOption(int selected, RSInterface dropdown) {
			if (selected == 0) {
				Configuration.enableNewHpBars = true;
			} else if (selected == 1) {
				Configuration.enableNewHpBars = false;
			}
        }
	},

    KEYBIND_SELECTION() {
        @Override
        public void selectOption(int selected, RSInterface dropdown) {
        	Keybinding.bind((dropdown.id - Keybinding.MIN_FRAME) / 3, selected);
        }
    },
    
    PLAYER_ATTACK_OPTION_PRIORITY() {
        @Override
        public void selectOption(int selected, RSInterface dropdown) {
        	Configuration.playerAttackOptionPriority = selected;
        }
    },

    NPC_ATTACK_OPTION_PRIORITY() {
        @Override
        public void selectOption(int selected, RSInterface dropdown) {
        	Configuration.npcAttackOptionPriority = selected;
        }
    };

    private Dropdown() {
    }
    
    public abstract void selectOption(int selected, RSInterface dropdown);
}
