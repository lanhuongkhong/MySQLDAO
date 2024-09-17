package lan.dev;

import lan.dev.data.dao.CategoryDao;
import lan.dev.data.impl.CategoryImpl;
import lan.dev.data.model.Category;

public class MainApp {

    public static void main(String[] args) {
        // Tạo đối tượng CategoryDao thông qua CategoryImpl
        CategoryDao categoryDao = new CategoryImpl();
        
        // Tạo một đối tượng Category với ID, tên và ảnh thumbnail
        Category cat = new Category(1, "Ao dai", "https://g"); // Đảm bảo ID phù hợp với cơ sở dữ liệu
        
        // Chèn danh mục vào cơ sở dữ liệu
        boolean insertResult = categoryDao.insert(cat);
        System.out.println("Chèn thành công: " + insertResult);

        // Tìm danh mục theo ID
        Category find = categoryDao.find(1); // Thay ID 121 bằng ID hợp lệ
        if (find != null) {
            System.out.println("Danh mục tìm thấy: " + find.getName());
            find.setName("ao qua dai"); // Cập nhật tên danh mục
            boolean updateResult = categoryDao.update(find); // Cập nhật danh mục trong cơ sở dữ liệu
            System.out.println("Cập nhật thành công: " + updateResult);
        } else {
            System.out.println("Danh mục không tìm thấy.");
        }
    }
}
