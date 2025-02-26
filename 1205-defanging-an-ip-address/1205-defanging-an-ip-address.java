class Solution {
    public String defangIPaddr(String address) {
        String res = address.replaceAll("\\.","[.]");
        return res;
    }
}