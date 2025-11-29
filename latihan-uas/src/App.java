import controllers.KaryawanController;
import repository.KaryawanRepository;
import views.KaryawanView;

public class App {
    public static void main(String[] args) {
        KaryawanRepository karyawanRepository = new KaryawanRepository();
        KaryawanController karyawanController = new KaryawanController(karyawanRepository);
        KaryawanView karyawanView = new KaryawanView(karyawanController);
        karyawanView.menu();
    }
}