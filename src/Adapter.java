//Модуль 09 Структурные паттерны. Адаптер
interface IInternalDeliveryService {
    void deliverOrder(String orderId);
    String getDeliveryStatus(String orderId);
}

class InternalDeliveryService implements IInternalDeliveryService {
    @Override
    public void deliverOrder(String orderId) {
        System.out.println("Order " + orderId + " is being delivered by internal service.");
    }

    @Override
    public String getDeliveryStatus(String orderId) {
        return "Status of order " + orderId + " from internal service.";
    }
}

class ExternalLogisticsServiceA {
    public void shipItem(int itemId) {
        System.out.println("Shipping item " + itemId + " with External Logistics Service A.");
    }

    public String trackShipment(int shipmentId) {
        return "Tracking shipment " + shipmentId + " with External Logistics Service A.";
    }
}
class ExternalLogisticsServiceB {
    public void sendPackage(String packageInfo) {
        System.out.println("Sending package with info: " + packageInfo + " via External Logistics Service B.");
    }

    public String checkPackageStatus(String trackingCode) {
        return "Checking status for package with tracking code " + trackingCode;
    }
}


class LogisticsAdapterA implements IInternalDeliveryService {
    private ExternalLogisticsServiceA externalServiceA;

    public LogisticsAdapterA(ExternalLogisticsServiceA externalServiceA) {
        this.externalServiceA = externalServiceA;
    }

    @Override
    public void deliverOrder(String orderId) {
        int itemId = Integer.parseInt(orderId);
        externalServiceA.shipItem(itemId);
    }

    @Override
    public String getDeliveryStatus(String orderId) {
        int shipmentId = Integer.parseInt(orderId);
        return externalServiceA.trackShipment(shipmentId);
    }
}

class LogisticsAdapterB implements IInternalDeliveryService {
    private ExternalLogisticsServiceB externalServiceB;

    public LogisticsAdapterB(ExternalLogisticsServiceB externalServiceB) {
        this.externalServiceB = externalServiceB;
    }

    @Override
    public void deliverOrder(String orderId) {
        externalServiceB.sendPackage(orderId);
    }

    @Override
    public String getDeliveryStatus(String orderId) {
        return externalServiceB.checkPackageStatus(orderId);
    }
}


class DeliveryServiceFactory {
    public static IInternalDeliveryService getDeliveryService(String serviceType) {
        switch (serviceType) {
            case "internal":
                return new InternalDeliveryService();
            case "externalA":
                return new LogisticsAdapterA(new ExternalLogisticsServiceA());
            case "externalB":
                return new LogisticsAdapterB(new ExternalLogisticsServiceB());
            default:
                throw new IllegalArgumentException("Unknown delivery service type.");
        }
    }
}
//


public class Adapter {
    public static void main(String[] args) {
        IInternalDeliveryService deliveryService = DeliveryServiceFactory.getDeliveryService("externalA");
        deliveryService.deliverOrder("123");
        System.out.println(deliveryService.getDeliveryStatus("123"));
    }
}
