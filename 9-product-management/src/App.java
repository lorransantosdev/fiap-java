import controller.ProductManagementController;
import repository.impl.ProductManagementRepositoryImpl;
import service.ProductManagementService;

public class App {
    private final ProductManagementController controller;

    public App(ProductManagementController controller) {
        this.controller = controller;
    }

    public void start() {
        controller.Start();
    }

    public static void main(String[] args) {

        ProductManagementController controller = new ProductManagementController(new ProductManagementService(new ProductManagementRepositoryImpl()));

        App app = new App(controller);
        app.start();
    }
}
