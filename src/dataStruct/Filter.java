package dataStruct;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Filter {
    private File country = new File("filter/countryData.csv");
    private ArrayList<String> countryName = new ArrayList<String>();
    private ArrayList<String> countryCode = new ArrayList<String>();

    public Filter() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(country)));
            String line = reader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                countryName.add(data[0].toUpperCase());
                countryCode.add(data[1].toUpperCase());
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * This method will update the country data file
     * 
     * @param filePath the path of the countryData.csv file
     */
    public void updateCountry(String filePath) {
        country = new File(filePath);
        countryName = new ArrayList<String>();
        countryCode = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(country)));
            String line = reader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                countryName.add(data[0].toUpperCase());
                countryCode.add(data[1].toUpperCase());
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * This method will check the invoic number, which is input as a int, is valid
     * or not.
     * if it is valid, return the invoice number in string, otherwise throw an
     * exception and display the error message.
     * The invoice number should be pure number, and the length should be equal or
     * more than 6.
     * 
     * @param invoiceNumber String
     * @return The invoice number in string.
     * @throws Exception
     */
    public String invoiceFilter(String invoiceNumber) throws Exception {

        String regex = "^[0-9]{6,}$";
        if (invoiceNumber.isEmpty() || !invoiceNumber.matches(regex)) {
            throw new Exception("Invoice number is not valid: " + invoiceNumber);
        } else {
            return invoiceNumber;
        }
    }

    /**
     * This method will check the stock code, which is input as a string, is valid
     * or not.
     * if it is valid, return the stock code in string, otherwise throw an
     * exception and display the error message
     * if the stock code contains a letter, it will be converted to upper case.
     * The stock code should be 5 digits number and a optional letter.
     * 
     * @param stockCode String
     * @return The stock code in string.
     * @throws Exception
     */
    public String stockCodeFilter(String stockCode) throws Exception {
        String regex = "^[0-9]{5}([a-zA-Z]{1})?$";
        if (stockCode.isEmpty() || !stockCode.matches(regex)) {
            throw new Exception(
                    "The stock code is not valid: " + stockCode);
        } else {
            return stockCode.toUpperCase();
        }
    }

    /**
     * This method will check the description, which is input as a string, is valid
     * or not.
     * if it is valid, return the description in string, otherwise throw an
     * exception and display the error message
     * The description should only contains letters, numbers, spaces, and
     * punctuation.
     * 
     * @param description String
     * @return The description in string.
     * @throws Exception
     */
    public String descriptionFilter(String description) throws Exception {
        String regex = "^[a-zA-Z0-9\\s\\p{Punct}]*$";
        if (description.isEmpty() || !description.matches(regex)) {
            throw new Exception(
                    "The description is not valid: " + description);
        } else {
            return description;
        }
    }

    /**
     * This method will check the quantity, which is input as a int, is valid or
     * not.
     * if it is valid, return the quantity in string, otherwise throw an exception
     * and display the error message
     * The quantity should be positive number.
     * 
     * @param quantity String
     * @return The quantity in string.
     * @throws Exception
     */
    public String quantityFilter(String quantity) throws Exception {
        String regex = "^[0-9]{1,}$";
        if (quantity.isEmpty() || !quantity.matches(regex)) {
            throw new Exception("The quantity is not valid: " + quantity);
        } else {
            return String.format("%d", quantity);
        }
    }

    /**
     * This method will check the date, which is input as a string, is valid or
     * not.
     * if it is valid, return the date in string, otherwise throw an exception
     * and display the error message
     * The date should be in the format of MM/DD/YY HH:MM.
     * 
     * @param date String, in the format of MM/DD/YY HH:MM.
     * @return The date in string if it is valid.
     * @throws Exception
     */
    public String dateFilter(String date) throws Exception {
        String regex = "^([0]{1}[1-9]{1}|[1]{1}[0-2]{1}|[0-9]{1})/([0]{1}[1-9]{1}|[1-2]{1}[0-9]{1}|[3]{1}[0-1]{1}|[0-9]{1})/[0-9]{2} ([0]{1}[0-9]{1}|[1]{1}[0-9]{1}|[2]{1}[0-3]{1}|[0-9]{1}):([0-5]{1}[0-9]{1}|[0-9]{1})$";
        if (date.isEmpty() || !date.matches(regex)) {
            throw new Exception("The date is not valid: " + date);
        } else {
            String[] dateSplit = date.split(" ");
            String[] dateSplit1 = dateSplit[0].split("/");
            String[] dateSplit2 = dateSplit[1].split(":");
            int month = Integer.parseInt(dateSplit1[0]);
            int day = Integer.parseInt(dateSplit1[1]);

            int year = Integer.parseInt("20" + dateSplit1[2]);
            int hour = Integer.parseInt(dateSplit2[0]);
            int minute = Integer.parseInt(dateSplit2[1]);
            // leap year day check
            if (month == 2) {
                if (year % 4 == 0) {
                    if (day > 29) {
                        throw new Exception("The date is not valid: " + date);
                    }
                } else {
                    if (day > 28) {
                        throw new Exception("The date is not valid: " + date);
                    }
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day > 30) {
                    throw new Exception("The date is not valid: " + date);
                }
            }
            return date;
        }
    }

    /**
     * This method will check the price, which is input as a double, is valid or
     * not.
     * if it is valid, return the price in string, otherwise throw an exception
     * and display the error message
     * The price should be positive float number.
     * 
     * @param price String, can be a integer or float number.
     * @return The price in string.
     * @throws Exception
     */
    public String priceFilter(String price) throws Exception {
        String regex = "^[0-9]{1,}[.]{0,1}[0-9]{0,}$";
        if (price.isEmpty() || !price.matches(regex)) {
            throw new Exception("The price is not valid: " + price);
        } else {
            return String.format("%.2f", price);
        }
    }

    /**
     * This method will check the customer ID, which is input as a string, is valid
     * or not.
     * if it is valid, return the customer ID in string, otherwise throw an
     * exception and display the error message
     * The customer ID should be 5 digits number.
     * 
     * @param customerID String
     * @return The customer ID in string.
     * @throws Exception
     */
    public String customerIDFilter(String customerID) throws Exception {
        String regex = "^[0-9]{5,}$";
        if (customerID.isEmpty() || !customerID.matches(regex)) {
            throw new Exception("The customer ID is not valid: " + customerID);
        } else {
            return String.valueOf(customerID);
        }
    }

    // Country filter
    // the country should be a valid country name in the list of countries.
    /**
     * This method will check the country, which is input as a string, is valid
     * or not.
     * if it is valid, return the country in string, otherwise throw an exception
     * and display the error message
     * 
     * @param country String, can be full name or ISO 3166-1 alpha-2 code.
     * @return The country in string.
     * @throws Exception
     */
    public String countryFilter(String country) throws Exception {
        if (country.isEmpty()) {
            throw new Exception("The country is empty: " + country);
        }
        if (country.length() == 2) {
            if (countryCode.contains(country.toUpperCase())) {
                return countryName.get(countryCode.indexOf(country.toUpperCase()));
            } else {
                throw new Exception("The country is not exist: " + country);
            }
        } else {
            if (!countryName.contains(country)) {
                throw new Exception("The country is not exist: " + country);
            } else {
                return country;
            }
        }

    }

    /**
     * This method will merge the day, month, year, hour, minute to a date String in
     * the format of MM/DD/YY HH:MM.
     * Notice: this method will not check the date is valid or not.
     * @param day    int, can be 1 or 2 digits.
     * @param month  int, can be 1 or 2 digits.
     * @param year   int can be 2 or 4 digits
     * @param hour   int, can be 1 or 2 digits, in 24-hour format.
     * @param minute int, can be 1 or 2 digits.
     * @return The date in string.
     */
    public String dateInt2String(int day, int month, int year, int hour, int minute) {
        String date = String.format("%02d/%02d/%02d %02d:%02d", month, day, year, hour, minute);
        return date;
    }
    /**
     * This method will merge the day, month, year to a date String in the format
     * of "MM/DD/YY HH:MM".
     * The month can be input as its full name or its short name.
     * Notice: this method will not check the date is valid or not (except month).
     * @param day int, can be 1 or 2 digits
     * @param monthInName String, can be full name or short name
     * @param year int, can be 4 digits or 2 digits.
     * @param hour int, can be 1 or 2 digits, in 24-hour format.
     * @param minute int, can be 1 or 2 digits.
     * @return The date in string.
     */
    public String dateInt2String(int day, String monthInName, int year, int hour, int minute) {
        String[] monthInDate = { "january", "february", "march", "april", "may", "june", "july", "august", "september",
                "october", "november", "december" };
        String[] monthInShort = { "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec" };
        int month = -1;
        monthInName = monthInName.toLowerCase();
        for (int i = 0; i < monthInDate.length; i++) {
            if (monthInName.equals(monthInDate[i])) {
                month = i + 1;
                break;
            }
        }
        if (month == -1) {
            for (int i = 0; i < monthInShort.length; i++) {
                if (monthInName.equals(monthInShort[i])) {
                    month = i + 1;
                    break;
                }
            }
        }
        if (month == -1) {
            throw new IllegalArgumentException("The month is not valid: " + monthInName);
        }
        String date = String.format("%s/%02d/%02d %02d:%02d", month, day, year, hour, minute);
        return date;
    }
    /**
     * This method will split the date String in the format of "MM/DD/YY HH:MM" to
     * an array of int.
     * Notice: this method will not check the date is valid or not.
     * @param date String, in the format of "MM/DD/YY HH:MM"
     * @return The array of int in the format of {month, day, year, hour, minute}.
     */
    public int[] dateString2Int(String date) {
        String[] dateSplit = date.split(" ");
        String[] dateSplit1 = dateSplit[0].split("/");
        String[] dateSplit2 = dateSplit[1].split(":");
        int month = Integer.parseInt(dateSplit1[0]);
        int day = Integer.parseInt(dateSplit1[1]);
        int year = Integer.parseInt("20" + dateSplit1[2]);
        int hour = Integer.parseInt(dateSplit2[0]);
        int minute = Integer.parseInt(dateSplit2[1]);
        int[] dateInt = { month, day, year, hour, minute };
        return dateInt;
    }

}
