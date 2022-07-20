package dataStruct;
public class UniObj {
    /**
     * This class store a set of attributes of one item or something.
     * The attributes will be stored in an array in order
     */
    private String[] allData;
    private int dataNum;
    public UniObj nextObj;

    UniObj(String... dataSet) {
        allData = dataSet;
        dataNum = dataSet.length;
    }

    /**
     * This method is a regular getter.
     * 
     * @param attrIndex The index of attribute that will be read.
     * @return The attribute that the index point to.
     */
    public String getAttr(int attrIndex) {
        try {
            // if (attrIndex < allData.length) {
            return allData[attrIndex];
            // }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * This method is a regular getter that get the total number of attributes.
     * @return The total number of attributes.
     */
    public int getDataNum() {
        return dataNum;
    }

    /**
     * This method is a regular getter for private variable.
     * 
     * @return the set of attributes.
     */
    public String[] getAlldata() {
        return allData;
    }

    /**
     * This method will cover the attribute in the position that the index point to.
     * 
     * @param attrIndex The index of attribute that will be covered.
     * @param attr      The new attribute
     * @return The old attribute if it exist, otherwise a empty string.
     */
    String setAttr(int attrIndex, String attr) {

        try {
            // if (attrIndex < allData.length) {
            String tmp = allData[attrIndex];
            allData[attrIndex] = attr;
            return tmp;
            // }
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }

    /**
     * This method is used to connect next object.
     * @param next The next object.
     */
    void setNextObj(UniObj nextObj) {
        this.nextObj = nextObj;
    }
    
    @Override
    public String toString() {
        String tmp = "";
        int i = 0;
        for (String cur : allData) {
            tmp += i++;
            tmp += ": ";
            tmp += cur;
            tmp += "; ";
        }
        return tmp;
    }

}
