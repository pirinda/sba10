/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui.bean;

import java.beans.*;

/**
 *
 * @author Sergio Flores
 */
public class DBeanFormBeanInfo extends SimpleBeanInfo {

    // Bean descriptor//GEN-FIRST:BeanDescriptor
    /*lazy BeanDescriptor*/
    private static BeanDescriptor getBdescriptor(){
        BeanDescriptor beanDescriptor = new BeanDescriptor  ( sba.lib.gui.bean.DBeanForm.class , null ); // NOI18N//GEN-HEADEREND:BeanDescriptor

    beanDescriptor.setValue("containerDelegate", "getBeanPanel");

        return beanDescriptor;     }//GEN-LAST:BeanDescriptor


    // Property identifiers//GEN-FIRST:Properties
    private static final int PROPERTY_accessibleContext = 0;
    private static final int PROPERTY_active = 1;
    private static final int PROPERTY_alignmentX = 2;
    private static final int PROPERTY_alignmentY = 3;
    private static final int PROPERTY_alwaysOnTop = 4;
    private static final int PROPERTY_alwaysOnTopSupported = 5;
    private static final int PROPERTY_background = 6;
    private static final int PROPERTY_backgroundSet = 7;
    private static final int PROPERTY_baselineResizeBehavior = 8;
    private static final int PROPERTY_beanPanel = 9;
    private static final int PROPERTY_bounds = 10;
    private static final int PROPERTY_bufferStrategy = 11;
    private static final int PROPERTY_colorModel = 12;
    private static final int PROPERTY_component = 13;
    private static final int PROPERTY_componentCount = 14;
    private static final int PROPERTY_componentListeners = 15;
    private static final int PROPERTY_componentOrientation = 16;
    private static final int PROPERTY_components = 17;
    private static final int PROPERTY_containerListeners = 18;
    private static final int PROPERTY_contentPane = 19;
    private static final int PROPERTY_cursor = 20;
    private static final int PROPERTY_cursorSet = 21;
    private static final int PROPERTY_defaultCloseOperation = 22;
    private static final int PROPERTY_displayable = 23;
    private static final int PROPERTY_doubleBuffered = 24;
    private static final int PROPERTY_dropTarget = 25;
    private static final int PROPERTY_enabled = 26;
    private static final int PROPERTY_focusable = 27;
    private static final int PROPERTY_focusableWindow = 28;
    private static final int PROPERTY_focusableWindowState = 29;
    private static final int PROPERTY_focusCycleRoot = 30;
    private static final int PROPERTY_focusCycleRootAncestor = 31;
    private static final int PROPERTY_focused = 32;
    private static final int PROPERTY_focusListeners = 33;
    private static final int PROPERTY_focusOwner = 34;
    private static final int PROPERTY_focusTraversable = 35;
    private static final int PROPERTY_focusTraversalKeys = 36;
    private static final int PROPERTY_focusTraversalKeysEnabled = 37;
    private static final int PROPERTY_focusTraversalPolicy = 38;
    private static final int PROPERTY_focusTraversalPolicyProvider = 39;
    private static final int PROPERTY_focusTraversalPolicySet = 40;
    private static final int PROPERTY_font = 41;
    private static final int PROPERTY_fontSet = 42;
    private static final int PROPERTY_foreground = 43;
    private static final int PROPERTY_foregroundSet = 44;
    private static final int PROPERTY_formResult = 45;
    private static final int PROPERTY_formStatus = 46;
    private static final int PROPERTY_glassPane = 47;
    private static final int PROPERTY_graphics = 48;
    private static final int PROPERTY_graphicsConfiguration = 49;
    private static final int PROPERTY_height = 50;
    private static final int PROPERTY_hierarchyBoundsListeners = 51;
    private static final int PROPERTY_hierarchyListeners = 52;
    private static final int PROPERTY_iconImage = 53;
    private static final int PROPERTY_iconImages = 54;
    private static final int PROPERTY_ignoreRepaint = 55;
    private static final int PROPERTY_inputContext = 56;
    private static final int PROPERTY_inputMethodListeners = 57;
    private static final int PROPERTY_inputMethodRequests = 58;
    private static final int PROPERTY_insets = 59;
    private static final int PROPERTY_JMenuBar = 60;
    private static final int PROPERTY_keyListeners = 61;
    private static final int PROPERTY_layeredPane = 62;
    private static final int PROPERTY_layout = 63;
    private static final int PROPERTY_lightweight = 64;
    private static final int PROPERTY_locale = 65;
    private static final int PROPERTY_location = 66;
    private static final int PROPERTY_locationByPlatform = 67;
    private static final int PROPERTY_locationOnScreen = 68;
    private static final int PROPERTY_locationRelativeTo = 69;
    private static final int PROPERTY_maximumSize = 70;
    private static final int PROPERTY_maximumSizeSet = 71;
    private static final int PROPERTY_minimumSize = 72;
    private static final int PROPERTY_minimumSizeSet = 73;
    private static final int PROPERTY_modal = 74;
    private static final int PROPERTY_modalExclusionType = 75;
    private static final int PROPERTY_modalityType = 76;
    private static final int PROPERTY_mostRecentFocusOwner = 77;
    private static final int PROPERTY_mouseListeners = 78;
    private static final int PROPERTY_mouseMotionListeners = 79;
    private static final int PROPERTY_mousePosition = 80;
    private static final int PROPERTY_mouseWheelListeners = 81;
    private static final int PROPERTY_name = 82;
    private static final int PROPERTY_opaque = 83;
    private static final int PROPERTY_ownedWindows = 84;
    private static final int PROPERTY_owner = 85;
    private static final int PROPERTY_parent = 86;
    private static final int PROPERTY_peer = 87;
    private static final int PROPERTY_preferredSize = 88;
    private static final int PROPERTY_preferredSizeSet = 89;
    private static final int PROPERTY_propertyChangeListeners = 90;
    private static final int PROPERTY_registry = 91;
    private static final int PROPERTY_resizable = 92;
    private static final int PROPERTY_rootPane = 93;
    private static final int PROPERTY_showing = 94;
    private static final int PROPERTY_size = 95;
    private static final int PROPERTY_title = 96;
    private static final int PROPERTY_toolkit = 97;
    private static final int PROPERTY_transferHandler = 98;
    private static final int PROPERTY_treeLock = 99;
    private static final int PROPERTY_undecorated = 100;
    private static final int PROPERTY_valid = 101;
    private static final int PROPERTY_visible = 102;
    private static final int PROPERTY_warningString = 103;
    private static final int PROPERTY_width = 104;
    private static final int PROPERTY_windowFocusListeners = 105;
    private static final int PROPERTY_windowListeners = 106;
    private static final int PROPERTY_windowStateListeners = 107;
    private static final int PROPERTY_x = 108;
    private static final int PROPERTY_y = 109;

    // Property array 
    /*lazy PropertyDescriptor*/
    private static PropertyDescriptor[] getPdescriptor(){
        PropertyDescriptor[] properties = new PropertyDescriptor[110];
    
        try {
            properties[PROPERTY_accessibleContext] = new PropertyDescriptor ( "accessibleContext", sba.lib.gui.bean.DBeanForm.class, "getAccessibleContext", null ); // NOI18N
            properties[PROPERTY_active] = new PropertyDescriptor ( "active", sba.lib.gui.bean.DBeanForm.class, "isActive", null ); // NOI18N
            properties[PROPERTY_alignmentX] = new PropertyDescriptor ( "alignmentX", sba.lib.gui.bean.DBeanForm.class, "getAlignmentX", null ); // NOI18N
            properties[PROPERTY_alignmentY] = new PropertyDescriptor ( "alignmentY", sba.lib.gui.bean.DBeanForm.class, "getAlignmentY", null ); // NOI18N
            properties[PROPERTY_alwaysOnTop] = new PropertyDescriptor ( "alwaysOnTop", sba.lib.gui.bean.DBeanForm.class, "isAlwaysOnTop", "setAlwaysOnTop" ); // NOI18N
            properties[PROPERTY_alwaysOnTopSupported] = new PropertyDescriptor ( "alwaysOnTopSupported", sba.lib.gui.bean.DBeanForm.class, "isAlwaysOnTopSupported", null ); // NOI18N
            properties[PROPERTY_background] = new PropertyDescriptor ( "background", sba.lib.gui.bean.DBeanForm.class, "getBackground", "setBackground" ); // NOI18N
            properties[PROPERTY_backgroundSet] = new PropertyDescriptor ( "backgroundSet", sba.lib.gui.bean.DBeanForm.class, "isBackgroundSet", null ); // NOI18N
            properties[PROPERTY_baselineResizeBehavior] = new PropertyDescriptor ( "baselineResizeBehavior", sba.lib.gui.bean.DBeanForm.class, "getBaselineResizeBehavior", null ); // NOI18N
            properties[PROPERTY_beanPanel] = new PropertyDescriptor ( "beanPanel", sba.lib.gui.bean.DBeanForm.class, "getBeanPanel", null ); // NOI18N
            properties[PROPERTY_bounds] = new PropertyDescriptor ( "bounds", sba.lib.gui.bean.DBeanForm.class, "getBounds", "setBounds" ); // NOI18N
            properties[PROPERTY_bufferStrategy] = new PropertyDescriptor ( "bufferStrategy", sba.lib.gui.bean.DBeanForm.class, "getBufferStrategy", null ); // NOI18N
            properties[PROPERTY_colorModel] = new PropertyDescriptor ( "colorModel", sba.lib.gui.bean.DBeanForm.class, "getColorModel", null ); // NOI18N
            properties[PROPERTY_component] = new IndexedPropertyDescriptor ( "component", sba.lib.gui.bean.DBeanForm.class, null, null, "getComponent", null ); // NOI18N
            properties[PROPERTY_componentCount] = new PropertyDescriptor ( "componentCount", sba.lib.gui.bean.DBeanForm.class, "getComponentCount", null ); // NOI18N
            properties[PROPERTY_componentListeners] = new PropertyDescriptor ( "componentListeners", sba.lib.gui.bean.DBeanForm.class, "getComponentListeners", null ); // NOI18N
            properties[PROPERTY_componentOrientation] = new PropertyDescriptor ( "componentOrientation", sba.lib.gui.bean.DBeanForm.class, "getComponentOrientation", "setComponentOrientation" ); // NOI18N
            properties[PROPERTY_components] = new PropertyDescriptor ( "components", sba.lib.gui.bean.DBeanForm.class, "getComponents", null ); // NOI18N
            properties[PROPERTY_containerListeners] = new PropertyDescriptor ( "containerListeners", sba.lib.gui.bean.DBeanForm.class, "getContainerListeners", null ); // NOI18N
            properties[PROPERTY_contentPane] = new PropertyDescriptor ( "contentPane", sba.lib.gui.bean.DBeanForm.class, "getContentPane", "setContentPane" ); // NOI18N
            properties[PROPERTY_cursor] = new PropertyDescriptor ( "cursor", sba.lib.gui.bean.DBeanForm.class, "getCursor", "setCursor" ); // NOI18N
            properties[PROPERTY_cursorSet] = new PropertyDescriptor ( "cursorSet", sba.lib.gui.bean.DBeanForm.class, "isCursorSet", null ); // NOI18N
            properties[PROPERTY_defaultCloseOperation] = new PropertyDescriptor ( "defaultCloseOperation", sba.lib.gui.bean.DBeanForm.class, "getDefaultCloseOperation", "setDefaultCloseOperation" ); // NOI18N
            properties[PROPERTY_displayable] = new PropertyDescriptor ( "displayable", sba.lib.gui.bean.DBeanForm.class, "isDisplayable", null ); // NOI18N
            properties[PROPERTY_doubleBuffered] = new PropertyDescriptor ( "doubleBuffered", sba.lib.gui.bean.DBeanForm.class, "isDoubleBuffered", null ); // NOI18N
            properties[PROPERTY_dropTarget] = new PropertyDescriptor ( "dropTarget", sba.lib.gui.bean.DBeanForm.class, "getDropTarget", "setDropTarget" ); // NOI18N
            properties[PROPERTY_enabled] = new PropertyDescriptor ( "enabled", sba.lib.gui.bean.DBeanForm.class, "isEnabled", "setEnabled" ); // NOI18N
            properties[PROPERTY_focusable] = new PropertyDescriptor ( "focusable", sba.lib.gui.bean.DBeanForm.class, "isFocusable", "setFocusable" ); // NOI18N
            properties[PROPERTY_focusableWindow] = new PropertyDescriptor ( "focusableWindow", sba.lib.gui.bean.DBeanForm.class, "isFocusableWindow", null ); // NOI18N
            properties[PROPERTY_focusableWindowState] = new PropertyDescriptor ( "focusableWindowState", sba.lib.gui.bean.DBeanForm.class, "getFocusableWindowState", "setFocusableWindowState" ); // NOI18N
            properties[PROPERTY_focusCycleRoot] = new PropertyDescriptor ( "focusCycleRoot", sba.lib.gui.bean.DBeanForm.class, "isFocusCycleRoot", "setFocusCycleRoot" ); // NOI18N
            properties[PROPERTY_focusCycleRootAncestor] = new PropertyDescriptor ( "focusCycleRootAncestor", sba.lib.gui.bean.DBeanForm.class, "getFocusCycleRootAncestor", null ); // NOI18N
            properties[PROPERTY_focused] = new PropertyDescriptor ( "focused", sba.lib.gui.bean.DBeanForm.class, "isFocused", null ); // NOI18N
            properties[PROPERTY_focusListeners] = new PropertyDescriptor ( "focusListeners", sba.lib.gui.bean.DBeanForm.class, "getFocusListeners", null ); // NOI18N
            properties[PROPERTY_focusOwner] = new PropertyDescriptor ( "focusOwner", sba.lib.gui.bean.DBeanForm.class, "getFocusOwner", null ); // NOI18N
            properties[PROPERTY_focusTraversable] = new PropertyDescriptor ( "focusTraversable", sba.lib.gui.bean.DBeanForm.class, "isFocusTraversable", null ); // NOI18N
            properties[PROPERTY_focusTraversalKeys] = new IndexedPropertyDescriptor ( "focusTraversalKeys", sba.lib.gui.bean.DBeanForm.class, null, null, "getFocusTraversalKeys", null ); // NOI18N
            properties[PROPERTY_focusTraversalKeysEnabled] = new PropertyDescriptor ( "focusTraversalKeysEnabled", sba.lib.gui.bean.DBeanForm.class, "getFocusTraversalKeysEnabled", "setFocusTraversalKeysEnabled" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicy] = new PropertyDescriptor ( "focusTraversalPolicy", sba.lib.gui.bean.DBeanForm.class, "getFocusTraversalPolicy", "setFocusTraversalPolicy" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicyProvider] = new PropertyDescriptor ( "focusTraversalPolicyProvider", sba.lib.gui.bean.DBeanForm.class, "isFocusTraversalPolicyProvider", "setFocusTraversalPolicyProvider" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicySet] = new PropertyDescriptor ( "focusTraversalPolicySet", sba.lib.gui.bean.DBeanForm.class, "isFocusTraversalPolicySet", null ); // NOI18N
            properties[PROPERTY_font] = new PropertyDescriptor ( "font", sba.lib.gui.bean.DBeanForm.class, "getFont", "setFont" ); // NOI18N
            properties[PROPERTY_fontSet] = new PropertyDescriptor ( "fontSet", sba.lib.gui.bean.DBeanForm.class, "isFontSet", null ); // NOI18N
            properties[PROPERTY_foreground] = new PropertyDescriptor ( "foreground", sba.lib.gui.bean.DBeanForm.class, "getForeground", "setForeground" ); // NOI18N
            properties[PROPERTY_foregroundSet] = new PropertyDescriptor ( "foregroundSet", sba.lib.gui.bean.DBeanForm.class, "isForegroundSet", null ); // NOI18N
            properties[PROPERTY_formResult] = new PropertyDescriptor ( "formResult", sba.lib.gui.bean.DBeanForm.class, "getFormResult", null ); // NOI18N
            properties[PROPERTY_formStatus] = new PropertyDescriptor ( "formStatus", sba.lib.gui.bean.DBeanForm.class, null, "setFormStatus" ); // NOI18N
            properties[PROPERTY_glassPane] = new PropertyDescriptor ( "glassPane", sba.lib.gui.bean.DBeanForm.class, "getGlassPane", "setGlassPane" ); // NOI18N
            properties[PROPERTY_graphics] = new PropertyDescriptor ( "graphics", sba.lib.gui.bean.DBeanForm.class, "getGraphics", null ); // NOI18N
            properties[PROPERTY_graphicsConfiguration] = new PropertyDescriptor ( "graphicsConfiguration", sba.lib.gui.bean.DBeanForm.class, "getGraphicsConfiguration", null ); // NOI18N
            properties[PROPERTY_height] = new PropertyDescriptor ( "height", sba.lib.gui.bean.DBeanForm.class, "getHeight", null ); // NOI18N
            properties[PROPERTY_hierarchyBoundsListeners] = new PropertyDescriptor ( "hierarchyBoundsListeners", sba.lib.gui.bean.DBeanForm.class, "getHierarchyBoundsListeners", null ); // NOI18N
            properties[PROPERTY_hierarchyListeners] = new PropertyDescriptor ( "hierarchyListeners", sba.lib.gui.bean.DBeanForm.class, "getHierarchyListeners", null ); // NOI18N
            properties[PROPERTY_iconImage] = new PropertyDescriptor ( "iconImage", sba.lib.gui.bean.DBeanForm.class, null, "setIconImage" ); // NOI18N
            properties[PROPERTY_iconImages] = new PropertyDescriptor ( "iconImages", sba.lib.gui.bean.DBeanForm.class, null, "setIconImages" ); // NOI18N
            properties[PROPERTY_ignoreRepaint] = new PropertyDescriptor ( "ignoreRepaint", sba.lib.gui.bean.DBeanForm.class, "getIgnoreRepaint", "setIgnoreRepaint" ); // NOI18N
            properties[PROPERTY_inputContext] = new PropertyDescriptor ( "inputContext", sba.lib.gui.bean.DBeanForm.class, "getInputContext", null ); // NOI18N
            properties[PROPERTY_inputMethodListeners] = new PropertyDescriptor ( "inputMethodListeners", sba.lib.gui.bean.DBeanForm.class, "getInputMethodListeners", null ); // NOI18N
            properties[PROPERTY_inputMethodRequests] = new PropertyDescriptor ( "inputMethodRequests", sba.lib.gui.bean.DBeanForm.class, "getInputMethodRequests", null ); // NOI18N
            properties[PROPERTY_insets] = new PropertyDescriptor ( "insets", sba.lib.gui.bean.DBeanForm.class, "getInsets", null ); // NOI18N
            properties[PROPERTY_JMenuBar] = new PropertyDescriptor ( "JMenuBar", sba.lib.gui.bean.DBeanForm.class, "getJMenuBar", "setJMenuBar" ); // NOI18N
            properties[PROPERTY_keyListeners] = new PropertyDescriptor ( "keyListeners", sba.lib.gui.bean.DBeanForm.class, "getKeyListeners", null ); // NOI18N
            properties[PROPERTY_layeredPane] = new PropertyDescriptor ( "layeredPane", sba.lib.gui.bean.DBeanForm.class, "getLayeredPane", "setLayeredPane" ); // NOI18N
            properties[PROPERTY_layout] = new PropertyDescriptor ( "layout", sba.lib.gui.bean.DBeanForm.class, "getLayout", "setLayout" ); // NOI18N
            properties[PROPERTY_lightweight] = new PropertyDescriptor ( "lightweight", sba.lib.gui.bean.DBeanForm.class, "isLightweight", null ); // NOI18N
            properties[PROPERTY_locale] = new PropertyDescriptor ( "locale", sba.lib.gui.bean.DBeanForm.class, "getLocale", "setLocale" ); // NOI18N
            properties[PROPERTY_location] = new PropertyDescriptor ( "location", sba.lib.gui.bean.DBeanForm.class, "getLocation", "setLocation" ); // NOI18N
            properties[PROPERTY_locationByPlatform] = new PropertyDescriptor ( "locationByPlatform", sba.lib.gui.bean.DBeanForm.class, "isLocationByPlatform", "setLocationByPlatform" ); // NOI18N
            properties[PROPERTY_locationOnScreen] = new PropertyDescriptor ( "locationOnScreen", sba.lib.gui.bean.DBeanForm.class, "getLocationOnScreen", null ); // NOI18N
            properties[PROPERTY_locationRelativeTo] = new PropertyDescriptor ( "locationRelativeTo", sba.lib.gui.bean.DBeanForm.class, null, "setLocationRelativeTo" ); // NOI18N
            properties[PROPERTY_maximumSize] = new PropertyDescriptor ( "maximumSize", sba.lib.gui.bean.DBeanForm.class, "getMaximumSize", "setMaximumSize" ); // NOI18N
            properties[PROPERTY_maximumSizeSet] = new PropertyDescriptor ( "maximumSizeSet", sba.lib.gui.bean.DBeanForm.class, "isMaximumSizeSet", null ); // NOI18N
            properties[PROPERTY_minimumSize] = new PropertyDescriptor ( "minimumSize", sba.lib.gui.bean.DBeanForm.class, "getMinimumSize", "setMinimumSize" ); // NOI18N
            properties[PROPERTY_minimumSizeSet] = new PropertyDescriptor ( "minimumSizeSet", sba.lib.gui.bean.DBeanForm.class, "isMinimumSizeSet", null ); // NOI18N
            properties[PROPERTY_modal] = new PropertyDescriptor ( "modal", sba.lib.gui.bean.DBeanForm.class, "isModal", "setModal" ); // NOI18N
            properties[PROPERTY_modalExclusionType] = new PropertyDescriptor ( "modalExclusionType", sba.lib.gui.bean.DBeanForm.class, "getModalExclusionType", "setModalExclusionType" ); // NOI18N
            properties[PROPERTY_modalityType] = new PropertyDescriptor ( "modalityType", sba.lib.gui.bean.DBeanForm.class, "getModalityType", "setModalityType" ); // NOI18N
            properties[PROPERTY_mostRecentFocusOwner] = new PropertyDescriptor ( "mostRecentFocusOwner", sba.lib.gui.bean.DBeanForm.class, "getMostRecentFocusOwner", null ); // NOI18N
            properties[PROPERTY_mouseListeners] = new PropertyDescriptor ( "mouseListeners", sba.lib.gui.bean.DBeanForm.class, "getMouseListeners", null ); // NOI18N
            properties[PROPERTY_mouseMotionListeners] = new PropertyDescriptor ( "mouseMotionListeners", sba.lib.gui.bean.DBeanForm.class, "getMouseMotionListeners", null ); // NOI18N
            properties[PROPERTY_mousePosition] = new PropertyDescriptor ( "mousePosition", sba.lib.gui.bean.DBeanForm.class, "getMousePosition", null ); // NOI18N
            properties[PROPERTY_mouseWheelListeners] = new PropertyDescriptor ( "mouseWheelListeners", sba.lib.gui.bean.DBeanForm.class, "getMouseWheelListeners", null ); // NOI18N
            properties[PROPERTY_name] = new PropertyDescriptor ( "name", sba.lib.gui.bean.DBeanForm.class, "getName", "setName" ); // NOI18N
            properties[PROPERTY_opaque] = new PropertyDescriptor ( "opaque", sba.lib.gui.bean.DBeanForm.class, "isOpaque", null ); // NOI18N
            properties[PROPERTY_ownedWindows] = new PropertyDescriptor ( "ownedWindows", sba.lib.gui.bean.DBeanForm.class, "getOwnedWindows", null ); // NOI18N
            properties[PROPERTY_owner] = new PropertyDescriptor ( "owner", sba.lib.gui.bean.DBeanForm.class, "getOwner", null ); // NOI18N
            properties[PROPERTY_parent] = new PropertyDescriptor ( "parent", sba.lib.gui.bean.DBeanForm.class, "getParent", null ); // NOI18N
            properties[PROPERTY_peer] = new PropertyDescriptor ( "peer", sba.lib.gui.bean.DBeanForm.class, "getPeer", null ); // NOI18N
            properties[PROPERTY_preferredSize] = new PropertyDescriptor ( "preferredSize", sba.lib.gui.bean.DBeanForm.class, "getPreferredSize", "setPreferredSize" ); // NOI18N
            properties[PROPERTY_preferredSizeSet] = new PropertyDescriptor ( "preferredSizeSet", sba.lib.gui.bean.DBeanForm.class, "isPreferredSizeSet", null ); // NOI18N
            properties[PROPERTY_propertyChangeListeners] = new PropertyDescriptor ( "propertyChangeListeners", sba.lib.gui.bean.DBeanForm.class, "getPropertyChangeListeners", null ); // NOI18N
            properties[PROPERTY_registry] = new PropertyDescriptor ( "registry", sba.lib.gui.bean.DBeanForm.class, "getRegistry", "setRegistry" ); // NOI18N
            properties[PROPERTY_resizable] = new PropertyDescriptor ( "resizable", sba.lib.gui.bean.DBeanForm.class, "isResizable", "setResizable" ); // NOI18N
            properties[PROPERTY_rootPane] = new PropertyDescriptor ( "rootPane", sba.lib.gui.bean.DBeanForm.class, "getRootPane", null ); // NOI18N
            properties[PROPERTY_showing] = new PropertyDescriptor ( "showing", sba.lib.gui.bean.DBeanForm.class, "isShowing", null ); // NOI18N
            properties[PROPERTY_size] = new PropertyDescriptor ( "size", sba.lib.gui.bean.DBeanForm.class, "getSize", "setSize" ); // NOI18N
            properties[PROPERTY_title] = new PropertyDescriptor ( "title", sba.lib.gui.bean.DBeanForm.class, "getTitle", "setTitle" ); // NOI18N
            properties[PROPERTY_toolkit] = new PropertyDescriptor ( "toolkit", sba.lib.gui.bean.DBeanForm.class, "getToolkit", null ); // NOI18N
            properties[PROPERTY_transferHandler] = new PropertyDescriptor ( "transferHandler", sba.lib.gui.bean.DBeanForm.class, "getTransferHandler", "setTransferHandler" ); // NOI18N
            properties[PROPERTY_treeLock] = new PropertyDescriptor ( "treeLock", sba.lib.gui.bean.DBeanForm.class, "getTreeLock", null ); // NOI18N
            properties[PROPERTY_undecorated] = new PropertyDescriptor ( "undecorated", sba.lib.gui.bean.DBeanForm.class, "isUndecorated", "setUndecorated" ); // NOI18N
            properties[PROPERTY_valid] = new PropertyDescriptor ( "valid", sba.lib.gui.bean.DBeanForm.class, "isValid", null ); // NOI18N
            properties[PROPERTY_visible] = new PropertyDescriptor ( "visible", sba.lib.gui.bean.DBeanForm.class, "isVisible", "setVisible" ); // NOI18N
            properties[PROPERTY_warningString] = new PropertyDescriptor ( "warningString", sba.lib.gui.bean.DBeanForm.class, "getWarningString", null ); // NOI18N
            properties[PROPERTY_width] = new PropertyDescriptor ( "width", sba.lib.gui.bean.DBeanForm.class, "getWidth", null ); // NOI18N
            properties[PROPERTY_windowFocusListeners] = new PropertyDescriptor ( "windowFocusListeners", sba.lib.gui.bean.DBeanForm.class, "getWindowFocusListeners", null ); // NOI18N
            properties[PROPERTY_windowListeners] = new PropertyDescriptor ( "windowListeners", sba.lib.gui.bean.DBeanForm.class, "getWindowListeners", null ); // NOI18N
            properties[PROPERTY_windowStateListeners] = new PropertyDescriptor ( "windowStateListeners", sba.lib.gui.bean.DBeanForm.class, "getWindowStateListeners", null ); // NOI18N
            properties[PROPERTY_x] = new PropertyDescriptor ( "x", sba.lib.gui.bean.DBeanForm.class, "getX", null ); // NOI18N
            properties[PROPERTY_y] = new PropertyDescriptor ( "y", sba.lib.gui.bean.DBeanForm.class, "getY", null ); // NOI18N
        }
        catch(IntrospectionException e) {
            e.printStackTrace();
        }//GEN-HEADEREND:Properties

    // Here you can add code for customizing the properties array.

        return properties;     }//GEN-LAST:Properties

    // EventSet identifiers//GEN-FIRST:Events
    private static final int EVENT_componentListener = 0;
    private static final int EVENT_containerListener = 1;
    private static final int EVENT_focusListener = 2;
    private static final int EVENT_hierarchyBoundsListener = 3;
    private static final int EVENT_hierarchyListener = 4;
    private static final int EVENT_inputMethodListener = 5;
    private static final int EVENT_keyListener = 6;
    private static final int EVENT_mouseListener = 7;
    private static final int EVENT_mouseMotionListener = 8;
    private static final int EVENT_mouseWheelListener = 9;
    private static final int EVENT_propertyChangeListener = 10;
    private static final int EVENT_windowFocusListener = 11;
    private static final int EVENT_windowListener = 12;
    private static final int EVENT_windowStateListener = 13;

    // EventSet array
    /*lazy EventSetDescriptor*/
    private static EventSetDescriptor[] getEdescriptor(){
        EventSetDescriptor[] eventSets = new EventSetDescriptor[14];
    
        try {
            eventSets[EVENT_componentListener] = new EventSetDescriptor ( sba.lib.gui.bean.DBeanForm.class, "componentListener", java.awt.event.ComponentListener.class, new String[] {"componentResized", "componentMoved", "componentShown", "componentHidden"}, "addComponentListener", "removeComponentListener" ); // NOI18N
            eventSets[EVENT_containerListener] = new EventSetDescriptor ( sba.lib.gui.bean.DBeanForm.class, "containerListener", java.awt.event.ContainerListener.class, new String[] {"componentAdded", "componentRemoved"}, "addContainerListener", "removeContainerListener" ); // NOI18N
            eventSets[EVENT_focusListener] = new EventSetDescriptor ( sba.lib.gui.bean.DBeanForm.class, "focusListener", java.awt.event.FocusListener.class, new String[] {"focusGained", "focusLost"}, "addFocusListener", "removeFocusListener" ); // NOI18N
            eventSets[EVENT_hierarchyBoundsListener] = new EventSetDescriptor ( sba.lib.gui.bean.DBeanForm.class, "hierarchyBoundsListener", java.awt.event.HierarchyBoundsListener.class, new String[] {"ancestorMoved", "ancestorResized"}, "addHierarchyBoundsListener", "removeHierarchyBoundsListener" ); // NOI18N
            eventSets[EVENT_hierarchyListener] = new EventSetDescriptor ( sba.lib.gui.bean.DBeanForm.class, "hierarchyListener", java.awt.event.HierarchyListener.class, new String[] {"hierarchyChanged"}, "addHierarchyListener", "removeHierarchyListener" ); // NOI18N
            eventSets[EVENT_inputMethodListener] = new EventSetDescriptor ( sba.lib.gui.bean.DBeanForm.class, "inputMethodListener", java.awt.event.InputMethodListener.class, new String[] {"inputMethodTextChanged", "caretPositionChanged"}, "addInputMethodListener", "removeInputMethodListener" ); // NOI18N
            eventSets[EVENT_keyListener] = new EventSetDescriptor ( sba.lib.gui.bean.DBeanForm.class, "keyListener", java.awt.event.KeyListener.class, new String[] {"keyTyped", "keyPressed", "keyReleased"}, "addKeyListener", "removeKeyListener" ); // NOI18N
            eventSets[EVENT_mouseListener] = new EventSetDescriptor ( sba.lib.gui.bean.DBeanForm.class, "mouseListener", java.awt.event.MouseListener.class, new String[] {"mouseClicked", "mousePressed", "mouseReleased", "mouseEntered", "mouseExited"}, "addMouseListener", "removeMouseListener" ); // NOI18N
            eventSets[EVENT_mouseMotionListener] = new EventSetDescriptor ( sba.lib.gui.bean.DBeanForm.class, "mouseMotionListener", java.awt.event.MouseMotionListener.class, new String[] {"mouseDragged", "mouseMoved"}, "addMouseMotionListener", "removeMouseMotionListener" ); // NOI18N
            eventSets[EVENT_mouseWheelListener] = new EventSetDescriptor ( sba.lib.gui.bean.DBeanForm.class, "mouseWheelListener", java.awt.event.MouseWheelListener.class, new String[] {"mouseWheelMoved"}, "addMouseWheelListener", "removeMouseWheelListener" ); // NOI18N
            eventSets[EVENT_propertyChangeListener] = new EventSetDescriptor ( sba.lib.gui.bean.DBeanForm.class, "propertyChangeListener", java.beans.PropertyChangeListener.class, new String[] {"propertyChange"}, "addPropertyChangeListener", "removePropertyChangeListener" ); // NOI18N
            eventSets[EVENT_windowFocusListener] = new EventSetDescriptor ( sba.lib.gui.bean.DBeanForm.class, "windowFocusListener", java.awt.event.WindowFocusListener.class, new String[] {"windowGainedFocus", "windowLostFocus"}, "addWindowFocusListener", "removeWindowFocusListener" ); // NOI18N
            eventSets[EVENT_windowListener] = new EventSetDescriptor ( sba.lib.gui.bean.DBeanForm.class, "windowListener", java.awt.event.WindowListener.class, new String[] {"windowOpened", "windowClosing", "windowClosed", "windowIconified", "windowDeiconified", "windowActivated", "windowDeactivated"}, "addWindowListener", "removeWindowListener" ); // NOI18N
            eventSets[EVENT_windowStateListener] = new EventSetDescriptor ( sba.lib.gui.bean.DBeanForm.class, "windowStateListener", java.awt.event.WindowStateListener.class, new String[] {"windowStateChanged"}, "addWindowStateListener", "removeWindowStateListener" ); // NOI18N
        }
        catch(IntrospectionException e) {
            e.printStackTrace();
        }//GEN-HEADEREND:Events

    // Here you can add code for customizing the event sets array.

        return eventSets;     }//GEN-LAST:Events

    // Method identifiers//GEN-FIRST:Methods
    private static final int METHOD_action0 = 0;
    private static final int METHOD_actionCancel1 = 1;
    private static final int METHOD_actionEdit2 = 2;
    private static final int METHOD_actionEditHelp3 = 3;
    private static final int METHOD_actionOk4 = 4;
    private static final int METHOD_actionPerformed5 = 5;
    private static final int METHOD_actionReload6 = 6;
    private static final int METHOD_add7 = 7;
    private static final int METHOD_add8 = 8;
    private static final int METHOD_add9 = 9;
    private static final int METHOD_add10 = 10;
    private static final int METHOD_add11 = 11;
    private static final int METHOD_add12 = 12;
    private static final int METHOD_addAllListeners13 = 13;
    private static final int METHOD_addNotify14 = 14;
    private static final int METHOD_addPropertyChangeListener15 = 15;
    private static final int METHOD_applyComponentOrientation16 = 16;
    private static final int METHOD_applyResourceBundle17 = 17;
    private static final int METHOD_applyResourceBundle18 = 18;
    private static final int METHOD_areFocusTraversalKeysSet19 = 19;
    private static final int METHOD_bounds20 = 20;
    private static final int METHOD_checkImage21 = 21;
    private static final int METHOD_checkImage22 = 22;
    private static final int METHOD_contains23 = 23;
    private static final int METHOD_contains24 = 24;
    private static final int METHOD_countComponents25 = 25;
    private static final int METHOD_createBufferStrategy26 = 26;
    private static final int METHOD_createBufferStrategy27 = 27;
    private static final int METHOD_createImage28 = 28;
    private static final int METHOD_createImage29 = 29;
    private static final int METHOD_createVolatileImage30 = 30;
    private static final int METHOD_createVolatileImage31 = 31;
    private static final int METHOD_deliverEvent32 = 32;
    private static final int METHOD_disable33 = 33;
    private static final int METHOD_dispatchEvent34 = 34;
    private static final int METHOD_dispose35 = 35;
    private static final int METHOD_doLayout36 = 36;
    private static final int METHOD_enable37 = 37;
    private static final int METHOD_enable38 = 38;
    private static final int METHOD_enableInputMethods39 = 39;
    private static final int METHOD_findComponentAt40 = 40;
    private static final int METHOD_findComponentAt41 = 41;
    private static final int METHOD_firePropertyChange42 = 42;
    private static final int METHOD_firePropertyChange43 = 43;
    private static final int METHOD_firePropertyChange44 = 44;
    private static final int METHOD_firePropertyChange45 = 45;
    private static final int METHOD_firePropertyChange46 = 46;
    private static final int METHOD_firePropertyChange47 = 47;
    private static final int METHOD_getBaseline48 = 48;
    private static final int METHOD_getBounds49 = 49;
    private static final int METHOD_getComponentAt50 = 50;
    private static final int METHOD_getComponentAt51 = 51;
    private static final int METHOD_getComponentZOrder52 = 52;
    private static final int METHOD_getFontMetrics53 = 53;
    private static final int METHOD_getIconImages54 = 54;
    private static final int METHOD_getListeners55 = 55;
    private static final int METHOD_getLocation56 = 56;
    private static final int METHOD_getMousePosition57 = 57;
    private static final int METHOD_getOwnerlessWindows58 = 58;
    private static final int METHOD_getPropertyChangeListeners59 = 59;
    private static final int METHOD_getSize60 = 60;
    private static final int METHOD_getWindows61 = 61;
    private static final int METHOD_gotFocus62 = 62;
    private static final int METHOD_handleEvent63 = 63;
    private static final int METHOD_hasFocus64 = 64;
    private static final int METHOD_hide65 = 65;
    private static final int METHOD_imageUpdate66 = 66;
    private static final int METHOD_insets67 = 67;
    private static final int METHOD_inside68 = 68;
    private static final int METHOD_invalidate69 = 69;
    private static final int METHOD_isAncestorOf70 = 70;
    private static final int METHOD_isDefaultLookAndFeelDecorated71 = 71;
    private static final int METHOD_isFocusCycleRoot72 = 72;
    private static final int METHOD_isFocusOwner73 = 73;
    private static final int METHOD_keyDown74 = 74;
    private static final int METHOD_keyUp75 = 75;
    private static final int METHOD_layout76 = 76;
    private static final int METHOD_list77 = 77;
    private static final int METHOD_list78 = 78;
    private static final int METHOD_list79 = 79;
    private static final int METHOD_list80 = 80;
    private static final int METHOD_list81 = 81;
    private static final int METHOD_locate82 = 82;
    private static final int METHOD_location83 = 83;
    private static final int METHOD_lostFocus84 = 84;
    private static final int METHOD_minimumSize85 = 85;
    private static final int METHOD_mouseDown86 = 86;
    private static final int METHOD_mouseDrag87 = 87;
    private static final int METHOD_mouseEnter88 = 88;
    private static final int METHOD_mouseExit89 = 89;
    private static final int METHOD_mouseMove90 = 90;
    private static final int METHOD_mouseUp91 = 91;
    private static final int METHOD_move92 = 92;
    private static final int METHOD_nextFocus93 = 93;
    private static final int METHOD_pack94 = 94;
    private static final int METHOD_paint95 = 95;
    private static final int METHOD_paintAll96 = 96;
    private static final int METHOD_paintComponents97 = 97;
    private static final int METHOD_postEvent98 = 98;
    private static final int METHOD_preferredSize99 = 99;
    private static final int METHOD_prepareImage100 = 100;
    private static final int METHOD_prepareImage101 = 101;
    private static final int METHOD_print102 = 102;
    private static final int METHOD_printAll103 = 103;
    private static final int METHOD_printComponents104 = 104;
    private static final int METHOD_remove105 = 105;
    private static final int METHOD_remove106 = 106;
    private static final int METHOD_remove107 = 107;
    private static final int METHOD_removeAll108 = 108;
    private static final int METHOD_removeAllListeners109 = 109;
    private static final int METHOD_removeNotify110 = 110;
    private static final int METHOD_removePropertyChangeListener111 = 111;
    private static final int METHOD_repaint112 = 112;
    private static final int METHOD_repaint113 = 113;
    private static final int METHOD_repaint114 = 114;
    private static final int METHOD_repaint115 = 115;
    private static final int METHOD_requestFocus116 = 116;
    private static final int METHOD_requestFocusInWindow117 = 117;
    private static final int METHOD_reshape118 = 118;
    private static final int METHOD_resize119 = 119;
    private static final int METHOD_resize120 = 120;
    private static final int METHOD_setBounds121 = 121;
    private static final int METHOD_setComponentZOrder122 = 122;
    private static final int METHOD_setDefaultLookAndFeelDecorated123 = 123;
    private static final int METHOD_setFocusTraversalKeys124 = 124;
    private static final int METHOD_setFormSettings125 = 125;
    private static final int METHOD_show126 = 126;
    private static final int METHOD_show127 = 127;
    private static final int METHOD_size128 = 128;
    private static final int METHOD_toBack129 = 129;
    private static final int METHOD_toFront130 = 130;
    private static final int METHOD_toString131 = 131;
    private static final int METHOD_transferFocus132 = 132;
    private static final int METHOD_transferFocusBackward133 = 133;
    private static final int METHOD_transferFocusDownCycle134 = 134;
    private static final int METHOD_transferFocusUpCycle135 = 135;
    private static final int METHOD_update136 = 136;
    private static final int METHOD_validate137 = 137;
    private static final int METHOD_validateForm138 = 138;

    // Method array 
    /*lazy MethodDescriptor*/
    private static MethodDescriptor[] getMdescriptor(){
        MethodDescriptor[] methods = new MethodDescriptor[139];
    
        try {
            methods[METHOD_action0] = new MethodDescriptor(java.awt.Component.class.getMethod("action", new Class[] {java.awt.Event.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_action0].setDisplayName ( "" );
            methods[METHOD_actionCancel1] = new MethodDescriptor(sba.lib.gui.bean.DBeanForm.class.getMethod("actionCancel", new Class[] {})); // NOI18N
            methods[METHOD_actionCancel1].setDisplayName ( "" );
            methods[METHOD_actionEdit2] = new MethodDescriptor(sba.lib.gui.bean.DBeanForm.class.getMethod("actionEdit", new Class[] {})); // NOI18N
            methods[METHOD_actionEdit2].setDisplayName ( "" );
            methods[METHOD_actionEditHelp3] = new MethodDescriptor(sba.lib.gui.bean.DBeanForm.class.getMethod("actionEditHelp", new Class[] {})); // NOI18N
            methods[METHOD_actionEditHelp3].setDisplayName ( "" );
            methods[METHOD_actionOk4] = new MethodDescriptor(sba.lib.gui.bean.DBeanForm.class.getMethod("actionOk", new Class[] {})); // NOI18N
            methods[METHOD_actionOk4].setDisplayName ( "" );
            methods[METHOD_actionPerformed5] = new MethodDescriptor(sba.lib.gui.bean.DBeanForm.class.getMethod("actionPerformed", new Class[] {java.awt.event.ActionEvent.class})); // NOI18N
            methods[METHOD_actionPerformed5].setDisplayName ( "" );
            methods[METHOD_actionReload6] = new MethodDescriptor(sba.lib.gui.bean.DBeanForm.class.getMethod("actionReload", new Class[] {})); // NOI18N
            methods[METHOD_actionReload6].setDisplayName ( "" );
            methods[METHOD_add7] = new MethodDescriptor(java.awt.Component.class.getMethod("add", new Class[] {java.awt.PopupMenu.class})); // NOI18N
            methods[METHOD_add7].setDisplayName ( "" );
            methods[METHOD_add8] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_add8].setDisplayName ( "" );
            methods[METHOD_add9] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.lang.String.class, java.awt.Component.class})); // NOI18N
            methods[METHOD_add9].setDisplayName ( "" );
            methods[METHOD_add10] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.awt.Component.class, int.class})); // NOI18N
            methods[METHOD_add10].setDisplayName ( "" );
            methods[METHOD_add11] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.awt.Component.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_add11].setDisplayName ( "" );
            methods[METHOD_add12] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.awt.Component.class, java.lang.Object.class, int.class})); // NOI18N
            methods[METHOD_add12].setDisplayName ( "" );
            methods[METHOD_addAllListeners13] = new MethodDescriptor(sba.lib.gui.bean.DBeanForm.class.getMethod("addAllListeners", new Class[] {})); // NOI18N
            methods[METHOD_addAllListeners13].setDisplayName ( "" );
            methods[METHOD_addNotify14] = new MethodDescriptor(java.awt.Dialog.class.getMethod("addNotify", new Class[] {})); // NOI18N
            methods[METHOD_addNotify14].setDisplayName ( "" );
            methods[METHOD_addPropertyChangeListener15] = new MethodDescriptor(java.awt.Window.class.getMethod("addPropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class})); // NOI18N
            methods[METHOD_addPropertyChangeListener15].setDisplayName ( "" );
            methods[METHOD_applyComponentOrientation16] = new MethodDescriptor(java.awt.Container.class.getMethod("applyComponentOrientation", new Class[] {java.awt.ComponentOrientation.class})); // NOI18N
            methods[METHOD_applyComponentOrientation16].setDisplayName ( "" );
            methods[METHOD_applyResourceBundle17] = new MethodDescriptor(java.awt.Window.class.getMethod("applyResourceBundle", new Class[] {java.util.ResourceBundle.class})); // NOI18N
            methods[METHOD_applyResourceBundle17].setDisplayName ( "" );
            methods[METHOD_applyResourceBundle18] = new MethodDescriptor(java.awt.Window.class.getMethod("applyResourceBundle", new Class[] {java.lang.String.class})); // NOI18N
            methods[METHOD_applyResourceBundle18].setDisplayName ( "" );
            methods[METHOD_areFocusTraversalKeysSet19] = new MethodDescriptor(java.awt.Container.class.getMethod("areFocusTraversalKeysSet", new Class[] {int.class})); // NOI18N
            methods[METHOD_areFocusTraversalKeysSet19].setDisplayName ( "" );
            methods[METHOD_bounds20] = new MethodDescriptor(java.awt.Component.class.getMethod("bounds", new Class[] {})); // NOI18N
            methods[METHOD_bounds20].setDisplayName ( "" );
            methods[METHOD_checkImage21] = new MethodDescriptor(java.awt.Component.class.getMethod("checkImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_checkImage21].setDisplayName ( "" );
            methods[METHOD_checkImage22] = new MethodDescriptor(java.awt.Component.class.getMethod("checkImage", new Class[] {java.awt.Image.class, int.class, int.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_checkImage22].setDisplayName ( "" );
            methods[METHOD_contains23] = new MethodDescriptor(java.awt.Component.class.getMethod("contains", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_contains23].setDisplayName ( "" );
            methods[METHOD_contains24] = new MethodDescriptor(java.awt.Component.class.getMethod("contains", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_contains24].setDisplayName ( "" );
            methods[METHOD_countComponents25] = new MethodDescriptor(java.awt.Container.class.getMethod("countComponents", new Class[] {})); // NOI18N
            methods[METHOD_countComponents25].setDisplayName ( "" );
            methods[METHOD_createBufferStrategy26] = new MethodDescriptor(java.awt.Window.class.getMethod("createBufferStrategy", new Class[] {int.class})); // NOI18N
            methods[METHOD_createBufferStrategy26].setDisplayName ( "" );
            methods[METHOD_createBufferStrategy27] = new MethodDescriptor(java.awt.Window.class.getMethod("createBufferStrategy", new Class[] {int.class, java.awt.BufferCapabilities.class})); // NOI18N
            methods[METHOD_createBufferStrategy27].setDisplayName ( "" );
            methods[METHOD_createImage28] = new MethodDescriptor(java.awt.Component.class.getMethod("createImage", new Class[] {java.awt.image.ImageProducer.class})); // NOI18N
            methods[METHOD_createImage28].setDisplayName ( "" );
            methods[METHOD_createImage29] = new MethodDescriptor(java.awt.Component.class.getMethod("createImage", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_createImage29].setDisplayName ( "" );
            methods[METHOD_createVolatileImage30] = new MethodDescriptor(java.awt.Component.class.getMethod("createVolatileImage", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_createVolatileImage30].setDisplayName ( "" );
            methods[METHOD_createVolatileImage31] = new MethodDescriptor(java.awt.Component.class.getMethod("createVolatileImage", new Class[] {int.class, int.class, java.awt.ImageCapabilities.class})); // NOI18N
            methods[METHOD_createVolatileImage31].setDisplayName ( "" );
            methods[METHOD_deliverEvent32] = new MethodDescriptor(java.awt.Container.class.getMethod("deliverEvent", new Class[] {java.awt.Event.class})); // NOI18N
            methods[METHOD_deliverEvent32].setDisplayName ( "" );
            methods[METHOD_disable33] = new MethodDescriptor(java.awt.Component.class.getMethod("disable", new Class[] {})); // NOI18N
            methods[METHOD_disable33].setDisplayName ( "" );
            methods[METHOD_dispatchEvent34] = new MethodDescriptor(java.awt.Component.class.getMethod("dispatchEvent", new Class[] {java.awt.AWTEvent.class})); // NOI18N
            methods[METHOD_dispatchEvent34].setDisplayName ( "" );
            methods[METHOD_dispose35] = new MethodDescriptor(java.awt.Window.class.getMethod("dispose", new Class[] {})); // NOI18N
            methods[METHOD_dispose35].setDisplayName ( "" );
            methods[METHOD_doLayout36] = new MethodDescriptor(java.awt.Container.class.getMethod("doLayout", new Class[] {})); // NOI18N
            methods[METHOD_doLayout36].setDisplayName ( "" );
            methods[METHOD_enable37] = new MethodDescriptor(java.awt.Component.class.getMethod("enable", new Class[] {})); // NOI18N
            methods[METHOD_enable37].setDisplayName ( "" );
            methods[METHOD_enable38] = new MethodDescriptor(java.awt.Component.class.getMethod("enable", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_enable38].setDisplayName ( "" );
            methods[METHOD_enableInputMethods39] = new MethodDescriptor(java.awt.Component.class.getMethod("enableInputMethods", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_enableInputMethods39].setDisplayName ( "" );
            methods[METHOD_findComponentAt40] = new MethodDescriptor(java.awt.Container.class.getMethod("findComponentAt", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_findComponentAt40].setDisplayName ( "" );
            methods[METHOD_findComponentAt41] = new MethodDescriptor(java.awt.Container.class.getMethod("findComponentAt", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_findComponentAt41].setDisplayName ( "" );
            methods[METHOD_firePropertyChange42] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, byte.class, byte.class})); // NOI18N
            methods[METHOD_firePropertyChange42].setDisplayName ( "" );
            methods[METHOD_firePropertyChange43] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, char.class, char.class})); // NOI18N
            methods[METHOD_firePropertyChange43].setDisplayName ( "" );
            methods[METHOD_firePropertyChange44] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, short.class, short.class})); // NOI18N
            methods[METHOD_firePropertyChange44].setDisplayName ( "" );
            methods[METHOD_firePropertyChange45] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, long.class, long.class})); // NOI18N
            methods[METHOD_firePropertyChange45].setDisplayName ( "" );
            methods[METHOD_firePropertyChange46] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, float.class, float.class})); // NOI18N
            methods[METHOD_firePropertyChange46].setDisplayName ( "" );
            methods[METHOD_firePropertyChange47] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, double.class, double.class})); // NOI18N
            methods[METHOD_firePropertyChange47].setDisplayName ( "" );
            methods[METHOD_getBaseline48] = new MethodDescriptor(java.awt.Component.class.getMethod("getBaseline", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_getBaseline48].setDisplayName ( "" );
            methods[METHOD_getBounds49] = new MethodDescriptor(java.awt.Component.class.getMethod("getBounds", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_getBounds49].setDisplayName ( "" );
            methods[METHOD_getComponentAt50] = new MethodDescriptor(java.awt.Container.class.getMethod("getComponentAt", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_getComponentAt50].setDisplayName ( "" );
            methods[METHOD_getComponentAt51] = new MethodDescriptor(java.awt.Container.class.getMethod("getComponentAt", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_getComponentAt51].setDisplayName ( "" );
            methods[METHOD_getComponentZOrder52] = new MethodDescriptor(java.awt.Container.class.getMethod("getComponentZOrder", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_getComponentZOrder52].setDisplayName ( "" );
            methods[METHOD_getFontMetrics53] = new MethodDescriptor(java.awt.Component.class.getMethod("getFontMetrics", new Class[] {java.awt.Font.class})); // NOI18N
            methods[METHOD_getFontMetrics53].setDisplayName ( "" );
            methods[METHOD_getIconImages54] = new MethodDescriptor(java.awt.Window.class.getMethod("getIconImages", new Class[] {})); // NOI18N
            methods[METHOD_getIconImages54].setDisplayName ( "" );
            methods[METHOD_getListeners55] = new MethodDescriptor(java.awt.Window.class.getMethod("getListeners", new Class[] {java.lang.Class.class})); // NOI18N
            methods[METHOD_getListeners55].setDisplayName ( "" );
            methods[METHOD_getLocation56] = new MethodDescriptor(java.awt.Component.class.getMethod("getLocation", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_getLocation56].setDisplayName ( "" );
            methods[METHOD_getMousePosition57] = new MethodDescriptor(java.awt.Container.class.getMethod("getMousePosition", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_getMousePosition57].setDisplayName ( "" );
            methods[METHOD_getOwnerlessWindows58] = new MethodDescriptor(java.awt.Window.class.getMethod("getOwnerlessWindows", new Class[] {})); // NOI18N
            methods[METHOD_getOwnerlessWindows58].setDisplayName ( "" );
            methods[METHOD_getPropertyChangeListeners59] = new MethodDescriptor(java.awt.Component.class.getMethod("getPropertyChangeListeners", new Class[] {java.lang.String.class})); // NOI18N
            methods[METHOD_getPropertyChangeListeners59].setDisplayName ( "" );
            methods[METHOD_getSize60] = new MethodDescriptor(java.awt.Component.class.getMethod("getSize", new Class[] {java.awt.Dimension.class})); // NOI18N
            methods[METHOD_getSize60].setDisplayName ( "" );
            methods[METHOD_getWindows61] = new MethodDescriptor(java.awt.Window.class.getMethod("getWindows", new Class[] {})); // NOI18N
            methods[METHOD_getWindows61].setDisplayName ( "" );
            methods[METHOD_gotFocus62] = new MethodDescriptor(java.awt.Component.class.getMethod("gotFocus", new Class[] {java.awt.Event.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_gotFocus62].setDisplayName ( "" );
            methods[METHOD_handleEvent63] = new MethodDescriptor(java.awt.Component.class.getMethod("handleEvent", new Class[] {java.awt.Event.class})); // NOI18N
            methods[METHOD_handleEvent63].setDisplayName ( "" );
            methods[METHOD_hasFocus64] = new MethodDescriptor(java.awt.Component.class.getMethod("hasFocus", new Class[] {})); // NOI18N
            methods[METHOD_hasFocus64].setDisplayName ( "" );
            methods[METHOD_hide65] = new MethodDescriptor(java.awt.Dialog.class.getMethod("hide", new Class[] {})); // NOI18N
            methods[METHOD_hide65].setDisplayName ( "" );
            methods[METHOD_imageUpdate66] = new MethodDescriptor(java.awt.Component.class.getMethod("imageUpdate", new Class[] {java.awt.Image.class, int.class, int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_imageUpdate66].setDisplayName ( "" );
            methods[METHOD_insets67] = new MethodDescriptor(java.awt.Container.class.getMethod("insets", new Class[] {})); // NOI18N
            methods[METHOD_insets67].setDisplayName ( "" );
            methods[METHOD_inside68] = new MethodDescriptor(java.awt.Component.class.getMethod("inside", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_inside68].setDisplayName ( "" );
            methods[METHOD_invalidate69] = new MethodDescriptor(java.awt.Container.class.getMethod("invalidate", new Class[] {})); // NOI18N
            methods[METHOD_invalidate69].setDisplayName ( "" );
            methods[METHOD_isAncestorOf70] = new MethodDescriptor(java.awt.Container.class.getMethod("isAncestorOf", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_isAncestorOf70].setDisplayName ( "" );
            methods[METHOD_isDefaultLookAndFeelDecorated71] = new MethodDescriptor(javax.swing.JDialog.class.getMethod("isDefaultLookAndFeelDecorated", new Class[] {})); // NOI18N
            methods[METHOD_isDefaultLookAndFeelDecorated71].setDisplayName ( "" );
            methods[METHOD_isFocusCycleRoot72] = new MethodDescriptor(java.awt.Container.class.getMethod("isFocusCycleRoot", new Class[] {java.awt.Container.class})); // NOI18N
            methods[METHOD_isFocusCycleRoot72].setDisplayName ( "" );
            methods[METHOD_isFocusOwner73] = new MethodDescriptor(java.awt.Component.class.getMethod("isFocusOwner", new Class[] {})); // NOI18N
            methods[METHOD_isFocusOwner73].setDisplayName ( "" );
            methods[METHOD_keyDown74] = new MethodDescriptor(java.awt.Component.class.getMethod("keyDown", new Class[] {java.awt.Event.class, int.class})); // NOI18N
            methods[METHOD_keyDown74].setDisplayName ( "" );
            methods[METHOD_keyUp75] = new MethodDescriptor(java.awt.Component.class.getMethod("keyUp", new Class[] {java.awt.Event.class, int.class})); // NOI18N
            methods[METHOD_keyUp75].setDisplayName ( "" );
            methods[METHOD_layout76] = new MethodDescriptor(java.awt.Container.class.getMethod("layout", new Class[] {})); // NOI18N
            methods[METHOD_layout76].setDisplayName ( "" );
            methods[METHOD_list77] = new MethodDescriptor(java.awt.Component.class.getMethod("list", new Class[] {})); // NOI18N
            methods[METHOD_list77].setDisplayName ( "" );
            methods[METHOD_list78] = new MethodDescriptor(java.awt.Component.class.getMethod("list", new Class[] {java.io.PrintStream.class})); // NOI18N
            methods[METHOD_list78].setDisplayName ( "" );
            methods[METHOD_list79] = new MethodDescriptor(java.awt.Component.class.getMethod("list", new Class[] {java.io.PrintWriter.class})); // NOI18N
            methods[METHOD_list79].setDisplayName ( "" );
            methods[METHOD_list80] = new MethodDescriptor(java.awt.Container.class.getMethod("list", new Class[] {java.io.PrintStream.class, int.class})); // NOI18N
            methods[METHOD_list80].setDisplayName ( "" );
            methods[METHOD_list81] = new MethodDescriptor(java.awt.Container.class.getMethod("list", new Class[] {java.io.PrintWriter.class, int.class})); // NOI18N
            methods[METHOD_list81].setDisplayName ( "" );
            methods[METHOD_locate82] = new MethodDescriptor(java.awt.Container.class.getMethod("locate", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_locate82].setDisplayName ( "" );
            methods[METHOD_location83] = new MethodDescriptor(java.awt.Component.class.getMethod("location", new Class[] {})); // NOI18N
            methods[METHOD_location83].setDisplayName ( "" );
            methods[METHOD_lostFocus84] = new MethodDescriptor(java.awt.Component.class.getMethod("lostFocus", new Class[] {java.awt.Event.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_lostFocus84].setDisplayName ( "" );
            methods[METHOD_minimumSize85] = new MethodDescriptor(java.awt.Container.class.getMethod("minimumSize", new Class[] {})); // NOI18N
            methods[METHOD_minimumSize85].setDisplayName ( "" );
            methods[METHOD_mouseDown86] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseDown", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseDown86].setDisplayName ( "" );
            methods[METHOD_mouseDrag87] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseDrag", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseDrag87].setDisplayName ( "" );
            methods[METHOD_mouseEnter88] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseEnter", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseEnter88].setDisplayName ( "" );
            methods[METHOD_mouseExit89] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseExit", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseExit89].setDisplayName ( "" );
            methods[METHOD_mouseMove90] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseMove", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseMove90].setDisplayName ( "" );
            methods[METHOD_mouseUp91] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseUp", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseUp91].setDisplayName ( "" );
            methods[METHOD_move92] = new MethodDescriptor(java.awt.Component.class.getMethod("move", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_move92].setDisplayName ( "" );
            methods[METHOD_nextFocus93] = new MethodDescriptor(java.awt.Component.class.getMethod("nextFocus", new Class[] {})); // NOI18N
            methods[METHOD_nextFocus93].setDisplayName ( "" );
            methods[METHOD_pack94] = new MethodDescriptor(java.awt.Window.class.getMethod("pack", new Class[] {})); // NOI18N
            methods[METHOD_pack94].setDisplayName ( "" );
            methods[METHOD_paint95] = new MethodDescriptor(java.awt.Container.class.getMethod("paint", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_paint95].setDisplayName ( "" );
            methods[METHOD_paintAll96] = new MethodDescriptor(java.awt.Component.class.getMethod("paintAll", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_paintAll96].setDisplayName ( "" );
            methods[METHOD_paintComponents97] = new MethodDescriptor(java.awt.Container.class.getMethod("paintComponents", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_paintComponents97].setDisplayName ( "" );
            methods[METHOD_postEvent98] = new MethodDescriptor(java.awt.Window.class.getMethod("postEvent", new Class[] {java.awt.Event.class})); // NOI18N
            methods[METHOD_postEvent98].setDisplayName ( "" );
            methods[METHOD_preferredSize99] = new MethodDescriptor(java.awt.Container.class.getMethod("preferredSize", new Class[] {})); // NOI18N
            methods[METHOD_preferredSize99].setDisplayName ( "" );
            methods[METHOD_prepareImage100] = new MethodDescriptor(java.awt.Component.class.getMethod("prepareImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_prepareImage100].setDisplayName ( "" );
            methods[METHOD_prepareImage101] = new MethodDescriptor(java.awt.Component.class.getMethod("prepareImage", new Class[] {java.awt.Image.class, int.class, int.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_prepareImage101].setDisplayName ( "" );
            methods[METHOD_print102] = new MethodDescriptor(java.awt.Container.class.getMethod("print", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_print102].setDisplayName ( "" );
            methods[METHOD_printAll103] = new MethodDescriptor(java.awt.Component.class.getMethod("printAll", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_printAll103].setDisplayName ( "" );
            methods[METHOD_printComponents104] = new MethodDescriptor(java.awt.Container.class.getMethod("printComponents", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_printComponents104].setDisplayName ( "" );
            methods[METHOD_remove105] = new MethodDescriptor(java.awt.Component.class.getMethod("remove", new Class[] {java.awt.MenuComponent.class})); // NOI18N
            methods[METHOD_remove105].setDisplayName ( "" );
            methods[METHOD_remove106] = new MethodDescriptor(java.awt.Container.class.getMethod("remove", new Class[] {int.class})); // NOI18N
            methods[METHOD_remove106].setDisplayName ( "" );
            methods[METHOD_remove107] = new MethodDescriptor(javax.swing.JDialog.class.getMethod("remove", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_remove107].setDisplayName ( "" );
            methods[METHOD_removeAll108] = new MethodDescriptor(java.awt.Container.class.getMethod("removeAll", new Class[] {})); // NOI18N
            methods[METHOD_removeAll108].setDisplayName ( "" );
            methods[METHOD_removeAllListeners109] = new MethodDescriptor(sba.lib.gui.bean.DBeanForm.class.getMethod("removeAllListeners", new Class[] {})); // NOI18N
            methods[METHOD_removeAllListeners109].setDisplayName ( "" );
            methods[METHOD_removeNotify110] = new MethodDescriptor(java.awt.Window.class.getMethod("removeNotify", new Class[] {})); // NOI18N
            methods[METHOD_removeNotify110].setDisplayName ( "" );
            methods[METHOD_removePropertyChangeListener111] = new MethodDescriptor(java.awt.Component.class.getMethod("removePropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class})); // NOI18N
            methods[METHOD_removePropertyChangeListener111].setDisplayName ( "" );
            methods[METHOD_repaint112] = new MethodDescriptor(java.awt.Component.class.getMethod("repaint", new Class[] {})); // NOI18N
            methods[METHOD_repaint112].setDisplayName ( "" );
            methods[METHOD_repaint113] = new MethodDescriptor(java.awt.Component.class.getMethod("repaint", new Class[] {long.class})); // NOI18N
            methods[METHOD_repaint113].setDisplayName ( "" );
            methods[METHOD_repaint114] = new MethodDescriptor(java.awt.Component.class.getMethod("repaint", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_repaint114].setDisplayName ( "" );
            methods[METHOD_repaint115] = new MethodDescriptor(javax.swing.JDialog.class.getMethod("repaint", new Class[] {long.class, int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_repaint115].setDisplayName ( "" );
            methods[METHOD_requestFocus116] = new MethodDescriptor(java.awt.Component.class.getMethod("requestFocus", new Class[] {})); // NOI18N
            methods[METHOD_requestFocus116].setDisplayName ( "" );
            methods[METHOD_requestFocusInWindow117] = new MethodDescriptor(java.awt.Component.class.getMethod("requestFocusInWindow", new Class[] {})); // NOI18N
            methods[METHOD_requestFocusInWindow117].setDisplayName ( "" );
            methods[METHOD_reshape118] = new MethodDescriptor(java.awt.Window.class.getMethod("reshape", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_reshape118].setDisplayName ( "" );
            methods[METHOD_resize119] = new MethodDescriptor(java.awt.Component.class.getMethod("resize", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_resize119].setDisplayName ( "" );
            methods[METHOD_resize120] = new MethodDescriptor(java.awt.Component.class.getMethod("resize", new Class[] {java.awt.Dimension.class})); // NOI18N
            methods[METHOD_resize120].setDisplayName ( "" );
            methods[METHOD_setBounds121] = new MethodDescriptor(java.awt.Window.class.getMethod("setBounds", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_setBounds121].setDisplayName ( "" );
            methods[METHOD_setComponentZOrder122] = new MethodDescriptor(java.awt.Container.class.getMethod("setComponentZOrder", new Class[] {java.awt.Component.class, int.class})); // NOI18N
            methods[METHOD_setComponentZOrder122].setDisplayName ( "" );
            methods[METHOD_setDefaultLookAndFeelDecorated123] = new MethodDescriptor(javax.swing.JDialog.class.getMethod("setDefaultLookAndFeelDecorated", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_setDefaultLookAndFeelDecorated123].setDisplayName ( "" );
            methods[METHOD_setFocusTraversalKeys124] = new MethodDescriptor(java.awt.Container.class.getMethod("setFocusTraversalKeys", new Class[] {int.class, java.util.Set.class})); // NOI18N
            methods[METHOD_setFocusTraversalKeys124].setDisplayName ( "" );
            methods[METHOD_setFormSettings125] = new MethodDescriptor(sba.lib.gui.bean.DBeanForm.class.getMethod("setFormSettings", new Class[] {sba.lib.gui.DGuiClient.class, int.class})); // NOI18N
            methods[METHOD_setFormSettings125].setDisplayName ( "" );
            methods[METHOD_show126] = new MethodDescriptor(java.awt.Component.class.getMethod("show", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_show126].setDisplayName ( "" );
            methods[METHOD_show127] = new MethodDescriptor(java.awt.Dialog.class.getMethod("show", new Class[] {})); // NOI18N
            methods[METHOD_show127].setDisplayName ( "" );
            methods[METHOD_size128] = new MethodDescriptor(java.awt.Component.class.getMethod("size", new Class[] {})); // NOI18N
            methods[METHOD_size128].setDisplayName ( "" );
            methods[METHOD_toBack129] = new MethodDescriptor(java.awt.Dialog.class.getMethod("toBack", new Class[] {})); // NOI18N
            methods[METHOD_toBack129].setDisplayName ( "" );
            methods[METHOD_toFront130] = new MethodDescriptor(java.awt.Window.class.getMethod("toFront", new Class[] {})); // NOI18N
            methods[METHOD_toFront130].setDisplayName ( "" );
            methods[METHOD_toString131] = new MethodDescriptor(java.awt.Component.class.getMethod("toString", new Class[] {})); // NOI18N
            methods[METHOD_toString131].setDisplayName ( "" );
            methods[METHOD_transferFocus132] = new MethodDescriptor(java.awt.Component.class.getMethod("transferFocus", new Class[] {})); // NOI18N
            methods[METHOD_transferFocus132].setDisplayName ( "" );
            methods[METHOD_transferFocusBackward133] = new MethodDescriptor(java.awt.Container.class.getMethod("transferFocusBackward", new Class[] {})); // NOI18N
            methods[METHOD_transferFocusBackward133].setDisplayName ( "" );
            methods[METHOD_transferFocusDownCycle134] = new MethodDescriptor(java.awt.Container.class.getMethod("transferFocusDownCycle", new Class[] {})); // NOI18N
            methods[METHOD_transferFocusDownCycle134].setDisplayName ( "" );
            methods[METHOD_transferFocusUpCycle135] = new MethodDescriptor(java.awt.Component.class.getMethod("transferFocusUpCycle", new Class[] {})); // NOI18N
            methods[METHOD_transferFocusUpCycle135].setDisplayName ( "" );
            methods[METHOD_update136] = new MethodDescriptor(javax.swing.JDialog.class.getMethod("update", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_update136].setDisplayName ( "" );
            methods[METHOD_validate137] = new MethodDescriptor(java.awt.Container.class.getMethod("validate", new Class[] {})); // NOI18N
            methods[METHOD_validate137].setDisplayName ( "" );
            methods[METHOD_validateForm138] = new MethodDescriptor(sba.lib.gui.bean.DBeanForm.class.getMethod("validateForm", new Class[] {})); // NOI18N
            methods[METHOD_validateForm138].setDisplayName ( "" );
        }
        catch( Exception e) {}//GEN-HEADEREND:Methods

    // Here you can add code for customizing the methods array.
    
        return methods;     }//GEN-LAST:Methods

    private static java.awt.Image iconColor16 = null;//GEN-BEGIN:IconsDef
    private static java.awt.Image iconColor32 = null;
    private static java.awt.Image iconMono16 = null;
    private static java.awt.Image iconMono32 = null;//GEN-END:IconsDef
    private static String iconNameC16 = null;//GEN-BEGIN:Icons
    private static String iconNameC32 = null;
    private static String iconNameM16 = null;
    private static String iconNameM32 = null;//GEN-END:Icons

    private static final int defaultPropertyIndex = -1;//GEN-BEGIN:Idx
    private static final int defaultEventIndex = -1;//GEN-END:Idx

    
//GEN-FIRST:Superclass

    // Here you can add code for customizing the Superclass BeanInfo.

//GEN-LAST:Superclass
	
    /**
     * Gets the bean's <code>BeanDescriptor</code>s.
     * 
     * @return BeanDescriptor describing the editable
     * properties of this bean.  May return null if the
     * information should be obtained by automatic analysis.
     */
    public BeanDescriptor getBeanDescriptor() {
	return getBdescriptor();
    }

    /**
     * Gets the bean's <code>PropertyDescriptor</code>s.
     * 
     * @return An array of PropertyDescriptors describing the editable
     * properties supported by this bean.  May return null if the
     * information should be obtained by automatic analysis.
     * <p>
     * If a property is indexed, then its entry in the result array will
     * belong to the IndexedPropertyDescriptor subclass of PropertyDescriptor.
     * A client of getPropertyDescriptors can use "instanceof" to check
     * if a given PropertyDescriptor is an IndexedPropertyDescriptor.
     */
    public PropertyDescriptor[] getPropertyDescriptors() {
	return getPdescriptor();
    }

    /**
     * Gets the bean's <code>EventSetDescriptor</code>s.
     * 
     * @return  An array of EventSetDescriptors describing the kinds of 
     * events fired by this bean.  May return null if the information
     * should be obtained by automatic analysis.
     */
    public EventSetDescriptor[] getEventSetDescriptors() {
	return getEdescriptor();
    }

    /**
     * Gets the bean's <code>MethodDescriptor</code>s.
     * 
     * @return  An array of MethodDescriptors describing the methods 
     * implemented by this bean.  May return null if the information
     * should be obtained by automatic analysis.
     */
    public MethodDescriptor[] getMethodDescriptors() {
	return getMdescriptor();
    }

    /**
     * A bean may have a "default" property that is the property that will
     * mostly commonly be initially chosen for update by human's who are 
     * customizing the bean.
     * @return  Index of default property in the PropertyDescriptor array
     * 		returned by getPropertyDescriptors.
     * <P>	Returns -1 if there is no default property.
     */
    public int getDefaultPropertyIndex() {
        return defaultPropertyIndex;
    }

    /**
     * A bean may have a "default" event that is the event that will
     * mostly commonly be used by human's when using the bean. 
     * @return Index of default event in the EventSetDescriptor array
     *		returned by getEventSetDescriptors.
     * <P>	Returns -1 if there is no default event.
     */
    public int getDefaultEventIndex() {
        return defaultEventIndex;
    }

    /**
     * This method returns an image object that can be used to
     * represent the bean in toolboxes, toolbars, etc.   Icon images
     * will typically be GIFs, but may in future include other formats.
     * <p>
     * Beans aren't required to provide icons and may return null from
     * this method.
     * <p>
     * There are four possible flavors of icons (16x16 color,
     * 32x32 color, 16x16 mono, 32x32 mono).  If a bean choses to only
     * support a single icon we recommend supporting 16x16 color.
     * <p>
     * We recommend that icons have a "transparent" background
     * so they can be rendered onto an existing background.
     *
     * @param  iconKind  The kind of icon requested.  This should be
     *    one of the constant values ICON_COLOR_16x16, ICON_COLOR_32x32, 
     *    ICON_MONO_16x16, or ICON_MONO_32x32.
     * @return  An image object representing the requested icon.  May
     *    return null if no suitable icon is available.
     */
    public java.awt.Image getIcon(int iconKind) {
        switch ( iconKind ) {
        case ICON_COLOR_16x16:
            if ( iconNameC16 == null )
                return null;
            else {
                if( iconColor16 == null )
                    iconColor16 = loadImage( iconNameC16 );
                return iconColor16;
            }
        case ICON_COLOR_32x32:
            if ( iconNameC32 == null )
                return null;
            else {
                if( iconColor32 == null )
                    iconColor32 = loadImage( iconNameC32 );
                return iconColor32;
            }
        case ICON_MONO_16x16:
            if ( iconNameM16 == null )
                return null;
            else {
                if( iconMono16 == null )
                    iconMono16 = loadImage( iconNameM16 );
                return iconMono16;
            }
        case ICON_MONO_32x32:
            if ( iconNameM32 == null )
                return null;
            else {
                if( iconMono32 == null )
                    iconMono32 = loadImage( iconNameM32 );
                return iconMono32;
            }
	default: return null;
        }
    }

}
