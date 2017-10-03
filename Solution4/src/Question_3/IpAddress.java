package Question_3;

public class IpAddress {
    private String ipAddress;

    public IpAddress(String address) {
        this.ipAddress = address;
    }

    public String getDottedDecimal(){
        return  this.ipAddress;
    }

    public String getOctet(int index){
        String[] Octets = this.ipAddress.split("\\.");
        return Octets[index-1];
    }




}
