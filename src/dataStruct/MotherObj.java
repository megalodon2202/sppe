package dataStruct;

import java.util.ArrayList;
import java.util.HashMap;

public class MotherObj {
    private UniObj head;
    private HashMap<String, ArrayList<UniObj>>[] theMap;
    private String[] attrNames;
    private int objNum;

    // theMap[0] is map for the first attribute, theMap[1] is for the second
    // attribute, and so on.
    // attrNames[0] is name for the first attribute, attrNames[1] is for the second
    // attribute, and so on.

    /**
     * This constructor will create and initilize a mother object.
     * 
     * @param dataNames The names of attributes.
     */
    MotherObj(String... dataNames) {
        theMap = new HashMap[dataNames.length];
        attrNames = dataNames;
        for (int i = 0; i < dataNames.length; i++) {
            theMap[i] = new HashMap<String, ArrayList<UniObj>>();
        }
        objNum = 0;

    }

    /**
     * This method will add an object to the mother object.
     * 
     * @param obj The object to be added.
     */
    void addObj(UniObj theObj) {// add the object to corresponding list
        if (head == null) {
            head = theObj;
        } else {
            UniObj current = head;
            while (current.nextObj != null) {
                current = current.nextObj;
            }
            current.nextObj = theObj;
        }
        for (int i = 0; i < attrNames.length; i++) {
            String attr = theObj.getAttr(i);
            if (theMap[i].containsKey(attr)) {
                theMap[i].get(attr).add(theObj);
            } else {
                ArrayList<UniObj> newList = new ArrayList<UniObj>();
                newList.add(theObj);
                theMap[i].put(attr, newList);
            }
        }
        objNum++;
    }

    /**
     * This method will get the number of objects in the mother object.
     * 
     * @return The number of objects.
     */
    UniObj[] getAllObjs() {
        UniObj[] allObjs = new UniObj[objNum];
        int i = 0;
        UniObj current = head;
        while (current != null) {
            allObjs[i] = current;
            current = current.nextObj;
            i++;
        }
        return allObjs;
    }

    /**
     * This method will get the index of attribute that with this name in the mother object.
     * 
     * @param attrName The name of attribute.
     * @return The index of attribute.
     */
    private int getAttrIndex(String attrName) {
        for (int i = 0; i < attrNames.length; i++) {
            if (attrNames[i].equals(attrName)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * This method will get the object that has this attribute.
     * @param attrName The name of attribute.
     * @param attrCont  The content of attribute.
     * @return  The object that has this attribute.
     */
    UniObj[] getObjsByAttr(String attrName, String attrCont) {
        ArrayList<UniObj> theList = theMap[getAttrIndex(attrName)].get(attrCont);
        if(theList == null){
            return new UniObj[0];
        }
        UniObj[] theObjs = new UniObj[theList.size()];
        theObjs=theList.toArray(theObjs);
        return theObjs;
    }

    /**
     * This method will get the number of objects that has this attribute.
     * @param attrName The name of attribute.
     * @param attrCont  The content of attribute.
     * @return  The number of objects that has this attribute.
     */
    int getObjNumByAttr(String attrName, String attrCont) {
        return theMap[getAttrIndex(attrName)].get(attrCont).size();
    }
    
    /**
     * This method will get the number of objects in the mother object.
     * 
     * @return The number of objects.
     */
    int getObjNum() {
        return objNum;
    }

}
