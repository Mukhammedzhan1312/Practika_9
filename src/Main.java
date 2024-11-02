/*interface IInternalDeliveryService {
    void deliverOrder(String orderId);
    String getDeliveryStatus(String orderId);
}

class InternalDeliveryService implements IInternalDeliveryService
{

    @Override
    public void deliverOrder(String orderId) {

    }

    @Override
    public String getDeliveryStatus(String orderId) {
        return null;
    }
}

class ExternalLogisticsServiceA{
    public void ShipItem(int itemId){}

    public String trackShipment(int shipmentId){
        return null;
    }

}


class ExternalGlovoAdapter {
    public void sendPackage(String packageInfo) {
        System.out.println();
    }

    public String checkPackageStatus(String trackingCode) {
        return null;
    }
}
class LogisticGlovoAdapter implements IInternalDeliveryService{
    private ExternalGlovoAdapter service;

    public LogisticGlovoAdapter(ExternalGlovoAdapter service) {
        this.service = service;
    }

    @Override
    public void deliverOrder(String orderId) {

    }

    @Override
    public String getDeliveryStatus(String orderId) {
        return null;
    }
}
public class Main {
    public static void main(String[] args) {
        String ordertype = "Nexia";
        IInternalDeliveryService service = null;
        if (ordertype == "Nexia") {
            service = new InternalDeliveryService();
        }

        else if (ordertype == "Glovo")
            service = new LogisticGlovoAdapter(new ExternalGlovoAdapter());
        service.deliverOrder("12345");
        String status = service.getDeliveryStatus("12345");
    }
}
 */