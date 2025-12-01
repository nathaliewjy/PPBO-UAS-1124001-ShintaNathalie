import controllers.DeviceController;
import repository.DeviceRepo;
import views.DeviceView;

public class Main {
    public static void main(String[] args) {
        DeviceRepo deviceRepo = new DeviceRepo();
        DeviceController deviceController = new DeviceController();
        DeviceView deviceView = new DeviceView();
        deviceView.menu();
    }
}