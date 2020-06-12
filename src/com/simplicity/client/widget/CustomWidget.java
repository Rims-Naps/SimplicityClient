package com.simplicity.client.widget;

import com.simplicity.client.Client;
import com.simplicity.client.RSInterface;
import com.simplicity.client.Sprite;

import java.awt.*;
import java.util.ArrayList;

public abstract class CustomWidget {
    public static final int OR1 = 0xFFB000;

    public int frame;

    public int id;

    public ArrayList<WidgetComponent> components;

    public int mainId;

    public CustomWidget(int id) {
        this.mainId = id;
        this.id = id + 1;
        this.components = new ArrayList<WidgetComponent>();
    }

    public abstract String getName();

    public abstract void init();

    public void add(RSInterface widget, int x, int y) {

        if (RSInterface.interfaceCache[widget.componentId] != null) {
            if (Widget.componentForMain.get(widget.componentId) != null) {
                // System.out.println("CustomWidget: Conflicting ID " +
                // widget.componentId + " @ " + getName() + " with: "
                // + Widget.componentForMain.get(widget.componentId));
            } else {
                // System.out.println(
                // "CustomWidget: Conflicting ID " + widget.componentId + " @ "
                // + getName() + " " + widget.type);
            }
            // return;
        }

        Widget.componentForMain.put(widget.componentId, getName());

        WidgetComponent component = new WidgetComponent(new Point(x, y), widget);
        component.componentId = widget.componentId;
        components.add(component);
    }

    public void addCenteredX(RSInterface widget, int y) {
        int x = 256 - (widget.width / 2);

        add(widget, x, y);
    }

    public void addWidget(int id, int x, int y) {
        Widget.componentForMain.put(id, getName());

        WidgetComponent component = new WidgetComponent(new Point(x, y), RSInterface.interfaceCache[id]);
        component.componentId = id;
        components.add(component);
    }

    public RSInterface addBackground(int background) {
        return addBackground(background, getName());
    }

    public RSInterface addBackground(int background, String title) {

        RSInterface tab = RSInterface.addTabInterface(id);
        tab.componentId = id;
        id++;

        Sprite sprite = Client.cacheSprite[background];

        int x = (512 - sprite.myWidth) / 2;
        int y = (334 - sprite.myHeight) / 2;

        int frame = 0;

        tab.totalChildren(3);

        RSInterface.addSprite(id, background);
        tab.child(frame++, id, x, y);
        id++;

        int closeX = sprite.myWidth - 73;

        if (closeX < 260) {
            closeX = 330;
        }

        RSInterface.addTextClose(40000, RSInterface.fonts);
        tab.child(frame++, 40000, closeX, y + 12);
        id++;

        RSInterface.addText(id, "@or1@" + title, RSInterface.fonts, 2, 0xFFFFFF, true, true);
        tab.child(frame++, id, 256, y + 11);
        id++;
        return tab;
    }

    public RSInterface addRectangleClickable(int opacity, int color, boolean filled, int width, int height,
                                             String... actions) {
        RSInterface tab = RSInterface.addTabInterface(id);
        tab.componentId = id;
        tab.parentID = id;
        tab.id = id;
        tab.disabledColor = color;
        tab.filled = filled;
        tab.type = 3;
        tab.atActionType = 5;
        tab.contentType = 0;
        tab.opacity = (byte) opacity;
        tab.width = width;
        tab.height = height;
        tab.atActionType = 1;
        tab.actions = actions;
        id++;
        return tab;
    }

    public RSInterface addNpc(int entityId) {
        RSInterface tab = RSInterface.addInterface(id);
        tab.componentId = id;
        tab.id = id;
        tab.parentID = id;
        tab.type = 6;
        tab.atActionType = 0;
        tab.contentType = 3291;
        tab.mediaType = 5;
        tab.enabledMediaType = 2;
//        tab.modelFileId = entityId;
        tab.mediaID = entityId;
        tab.width = 136;
        tab.height = 168;
        tab.opacity = 0;
        tab.hoverType = 0;
        tab.modelZoom = 575;
        tab.modelRotation1 = 150;
        tab.modelRotation2 = 0;
        tab.disabledAnimationId = -1;
        tab.enabledAnimationId = -1;
        id++;
        return tab;
    }

    public RSInterface addSprite(int spriteId) {
        RSInterface tab = RSInterface.addInterface(id);
        tab.componentId = id;
        tab.id = id;
        tab.parentID = id;
        tab.componentId = id;
        tab.type = 5;
        tab.atActionType = 0;
        tab.contentType = 0;
        tab.hoverType = 52;

        Sprite sprite = Client.cacheSprite[spriteId];

        tab.enabledSprite = sprite;
        tab.disabledSprite = sprite;
        tab.width = 512;
        tab.height = 334;
        id++;
        return tab;
    }

    public RSInterface addConfigButton(String tooltip, int sprite1, int sprite2, int aT, int configSlot, int configId) {
        RSInterface tab = RSInterface.addInterface(id);
        tab.parentID = id;
        tab.id = id;
        tab.type = 5;
        tab.atActionType = aT;
        tab.componentId = id;
        tab.contentType = 0;
        Sprite sprite = Client.cacheSprite[sprite1];
        tab.width = sprite.myWidth;
        tab.height = sprite.myHeight;
        tab.opacity = 0;
        tab.hoverType = -1;
        tab.valueCompareType = new int[1];
        tab.requiredValues = new int[1];
        tab.valueCompareType[0] = 1;
        tab.requiredValues[0] = configSlot;
        tab.valueIndexArray = new int[1][3];
        tab.valueIndexArray[0][0] = 5;
        tab.valueIndexArray[0][1] = configId;
        tab.valueIndexArray[0][2] = 0;
        tab.disabledSprite = sprite;
        tab.enabledSprite = Client.cacheSprite[sprite2];
        tab.tooltip = tooltip;
        return tab;
    }

    public RSInterface addPercentageBar(int percentageDimension, int percentageTotal, int percentageSpriteEmpty,
                                        int percentageSpriteFull, boolean verticleBar) {
        System.out.println(getName() + " percentage bar: " + id);
        RSInterface tab = RSInterface.addInterface(id);
        tab.id = id;
        tab.parentID = id;
        tab.componentId = id;
        tab.type = 20;
        tab.atActionType = 0;
        tab.contentType = 0;
        tab.opacity = 0;
        tab.hoverType = 0;
        tab.percentageCompleted = 100;
        tab.percentageDimension = percentageDimension;
        tab.percentageSpriteFull = percentageSpriteFull;
        tab.percentageSpriteEmpty = percentageSpriteEmpty;
        tab.percentageTotal = percentageTotal;
        tab.verticleBar = verticleBar;
        tab.width = 0;
        tab.height = 0;
        id++;
        return tab;
    }

    public RSInterface addItemContainer(int w, int h, int x, int y, String[] actions, String string) {
        System.out.println(getName() + " container: " + string + ": " + id);
        RSInterface tab = RSInterface.addInterface(id);
        tab.componentId = id;
        tab.width = w;
        tab.height = h;
        tab.inv = new int[w * h];
        tab.invStackSizes = new int[w * h];
        for (int i = 0; i < tab.inv.length; i++) {
            tab.inv[i] = 996;
            tab.invStackSizes[i] = Integer.MAX_VALUE;
        }
        tab.usableItemInterface = false;
        tab.invSpritePadX = x;
        tab.invSpritePadY = y;
        tab.spritesX = new int[20];
        tab.spritesY = new int[20];
        tab.sprites = new Sprite[20];
        if (actions != null) {
            tab.actions = new String[5];
            tab.actions = actions;
        }
        tab.type = 2;
        id++;
        return tab;
    }

    public RSInterface addButton(String name, int sprite1, int sprite2, int textSize, int colour) {
        RSInterface tab = RSInterface.addTabInterface(id);
        tab.componentId = id;
        id++;

        int frame = 0;

        tab.totalChildren(3);

        Sprite sprite = Client.cacheSprite[sprite1];

        int width = sprite.myWidth;
        int height = sprite.myHeight;

        tab.width = width;
        tab.height = height;

        RSInterface.addHoverButton(id, sprite1, width, height, "Select @lre@" + name, -1, id + 1, 5);
        RSInterface.addHoveredButton(id + 1, sprite2, width, height, id + 2);
        tab.child(frame++, id, 0, 0);
        tab.child(frame++, id + 1, 0, 0);
        id += 3;

        int textHeight = 13 + textSize;

        if (name.contains("#")) {
            name = "" + id;
        }

        int textDecrease = textSize > 1 ? -1 : 1;

        RSInterface.addText(id, textSize == -1 ? "" : name, RSInterface.fonts, textSize == -1 ? 0 : textSize, colour,
                true, true);
        tab.child(frame++, id, width / 2,
                ((height / 2) - (textHeight / 2)) + (textSize == 0 ? +textDecrease : -textDecrease));
        id++;
        return tab;
    }

    public RSInterface addButtonList(String[] list, int sprite1, int sprite2, int textSize, int colour, int offset,
                                     boolean verticle) {
        RSInterface tab = RSInterface.addTabInterface(id);
        tab.componentId = id;
        id++;

        tab.totalChildren(list.length);

        Sprite sprite = Client.cacheSprite[sprite1];

        int height = sprite.myHeight + 1;
        int width = sprite.myWidth + 1;

        int frame = 0;

        int y = 0;
        int x = 0;

        for (String s : list) {
            RSInterface button = addButton(s, sprite1, sprite2, textSize, colour);
            tab.child(frame++, button.componentId, x, y);
            if (verticle) {
                y += height + offset;
            } else {
                x += width + offset;
            }
        }
        id++;
        return tab;
    }

    public RSInterface addScrollbarWithText(String text, String tooltip, int size, int colour, int scrollHeight,
                                            int scrollWidth, int lineAmount) {
        RSInterface scroll = RSInterface.addInterface(id);
        scroll.componentId = id;
        id++;
        scroll.totalChildren(lineAmount);
        scroll.height = scrollHeight;
        scroll.width = scrollWidth;
        scroll.scrollMax = scrollHeight + (lineAmount * (11 + size));
        int scroll_frame = 0;

        int y = 5;

        for (int i = 0; i < lineAmount; i++) {
            RSInterface.addHoverText(id, text + (text.contains("#") ? "" + id : ""), tooltip, RSInterface.fonts, size,
                    colour, false, true, 150);
            RSInterface.setBounds(id, 5, y, scroll_frame, scroll);
            scroll_frame++;
            id++;
            y += 12 + size;
        }
        return scroll;
    }

    public RSInterface addScrollbarWithItem(int w, int h, int x, int y, String[] action, int scrollHeight,
                                            int scrollWidth) {
        RSInterface scroll = RSInterface.addInterface(id);
        scroll.componentId = id;
        id++;

        scroll.totalChildren(1);
        scroll.height = scrollHeight;
        scroll.width = scrollWidth;
        scroll.scrollMax = 35 * h;
        int scroll_frame = 0;

        System.out.println(getName() + " container: " + id);
        RSInterface item = RSInterface.addToItemGroup(id, w, h, x, y, action == null ? false : true, "", "", "");

        for (int i = 0; i < item.inv.length; i++) {
            item.inv[i] = 996;
            item.invStackSizes[i] = Integer.MAX_VALUE;
        }

        item.actions = new String[5];

        for (int i = 0; i < item.actions.length; i++) {
            item.actions[i] = null;
        }

        if (action != null) {
            for (int i = 0; i < action.length; i++) {
                item.actions[i] = action[i];
            }
        }

        RSInterface.setBounds(id, 5, 2 + y, scroll_frame, scroll);
        scroll_frame++;
        id++;
        return scroll;
    }

    public RSInterface addClickText(String text, int idx, int color, boolean center, boolean shadowed) {
        RSInterface tab = RSInterface.addInterface(id);
        tab.parentID = id;
        tab.id = id;
        tab.componentId = id;
        tab.type = 4;
        tab.atActionType = 1;
        tab.width = RSInterface.fonts[idx].getTextWidth(text);
        tab.height = idx == 0 ? 12 : 15;
        tab.contentType = 0;
        tab.opacity = 0;
        tab.hoverType = -1;
        tab.centerText = center;
        tab.shadowed = shadowed;
        tab.textDrawingAreas = RSInterface.fonts[idx];
        tab.message = text + " " + (text.contains("#") ? id : "");
        tab.tooltip = "Select @lre@" + text;
        tab.disabledColor = color;
        id++;
        return tab;
    }

    public RSInterface addClickText(String text, int idx, int color) {
        return addClickText(text, idx, color, true, true);
    }

    public RSInterface addClickText(String text, int idx, int color, boolean center) {
        return addClickText(text, idx, color, center, true);
    }

    public RSInterface addText(String text, int size, int color) {
        return addText(text, size, color, false, false, false, true);
    }

    public RSInterface addCenteredText(String text, int size, int color) {
        return addText(text, size, color, true, false, false, true);
    }

    public RSInterface addText(String text, int size) {
        return addText(text, size, CustomWidget.OR1, false, false, false, true);
    }

    public RSInterface addCenteredText(String text, int size) {
        return addText(text, size, CustomWidget.OR1, true, false, false, true);
    }
    
    public RSInterface addRightAlignedText(String text, int size) {
        return addText(text, size, CustomWidget.OR1, true, true, false, true);
    }
    
    public RSInterface addRightAlignedText(String text, int size, int color) {
        return addText(text, size, color, false, true, false, true);
    }

    private RSInterface addText(String text, int idx, int color, boolean center, boolean rightAligned,
                               boolean rollingText, boolean shadow) {
        RSInterface tab = RSInterface.addTabInterface(id);
        tab.parentID = id;
        tab.id = id;
        tab.componentId = id;
        tab.type = 4;
        tab.atActionType = 0;
        tab.width = 0;
        tab.height = idx == 0 ? 12 : 15;
        tab.contentType = 0;
        tab.opacity = 0;
        tab.hoverType = -1;
        tab.centerText = center;
        tab.rightAlignText = rightAligned;
        tab.shadowed = shadow;
        tab.textDrawingAreas = RSInterface.fonts[idx];
        tab.message = text.contains("#") ? text + ":" + id : text;
        tab.disabledColor = color;
        id++;
        return tab;
    }

    public RSInterface addTextList(String[] list, int textSize, int colour, boolean center, int offset,
                                   boolean verticle) {
        RSInterface tab = RSInterface.addTabInterface(id);
        tab.componentId = id;
        id++;

        tab.totalChildren(list.length);

        int frame = 0;

        int y = 0;
        int x = 0;

        int length = offset;

        for (String s : list) {

            if(offset == -1) {
                length = RSInterface.fonts[textSize].getTextWidth(s) + 4;
            }

            RSInterface button = addText(s, textSize, colour, center, false, false, true);
            tab.child(frame++, button.componentId, x, y);

            if (verticle) {
                y += length;
            } else {
                x += length;
            }
        }
        id++;
        return tab;
    }

    public RSInterface addGroup(WidgetGroup group) {
        RSInterface scroll = RSInterface.addInterface(id);
        scroll.componentId = id;

        id++;

        int single = 0;

        if (group.singleComponents != null) {
            single = group.singleComponents.size();
        }

        scroll.totalChildren(single + (group.lines * group.multipleComponents.size()));

        scroll.height = group.scrollHeight;
        scroll.width = group.scrollWidth;

        int scrollMax = (group.difference / 2) + (group.difference * group.lines);

        if (scrollMax < group.scrollHeight) {
            scrollMax = group.scrollMax;
        }

        scroll.scrollMax = scrollMax;

        int scroll_frame = 0;

        int y = 0;

        for (int i = 0; i < group.lines; i++) {
            for (WidgetComponent w : group.multipleComponents) {
                RSInterface rs = RSInterface.addInterface(id);
                rs.copy(w.componentId);
                RSInterface.setBounds(rs.id, w.point.x + group.offsetX, w.point.y + y + group.offsetY, scroll_frame,
                        scroll);
                scroll_frame++;
                id++;
            }
            y += group.difference;
        }

        id++;

        if (group.singleComponents != null) {
            for (WidgetComponent w : group.singleComponents) {
                RSInterface rs = RSInterface.addInterface(id);
                rs.copy(w.componentId);
                RSInterface.setBounds(rs.id, w.point.x + group.offsetX, w.point.y + group.offsetY, scroll_frame,
                        scroll);
                scroll_frame++;
                id++;
            }
        }
        return scroll;
    }

    public RSInterface getInterface() {
        return RSInterface.interfaceCache[mainId];
    }
}
