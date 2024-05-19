package homework1;

import java.util.Comparator;

class Entry implements Comparable<Entry> {
    private String name;
    private String address;
    private String city;
    private String postcode;
    private String country;
    private String phoneNumber;

    public Entry(String name, String address, String city, String postcode, String country, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Entry other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", City: " + city + ", Postcode: " + postcode + ", Country: " + country + ", Phone Number: " + phoneNumber;
    }
}

class AddressComparator implements Comparator<Entry> {
    @Override
    public int compare(Entry e1, Entry e2) {
        return e1.getAddress().compareTo(e2.getAddress());
    }
}

class CityComparator implements Comparator<Entry> {
    @Override
    public int compare(Entry e1, Entry e2) {
        return e1.getCity().compareTo(e2.getCity());
    }
}

class PostcodeComparator implements Comparator<Entry> {
    @Override
    public int compare(Entry e1, Entry e2) {
        return e1.getPostcode().compareTo(e2.getPostcode());
    }
}

class CountryComparator implements Comparator<Entry> {
    @Override
    public int compare(Entry e1, Entry e2) {
        return e1.getCountry().compareTo(e2.getCountry());
    }
}

class PhoneNumberComparator implements Comparator<Entry> {
    @Override
    public int compare(Entry e1, Entry e2) {
        return e1.getPhoneNumber().compareTo(e2.getPhoneNumber());
    }
}

class NameComparator implements Comparator<Entry> {
    @Override
    public int compare(Entry e1, Entry e2) {
        return e1.getName().compareTo(e2.getName());
    }
}