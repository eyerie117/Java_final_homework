public class Notebook {
    String model; // Модель
    String brand; // Фирма-производитель
    String colour; // Цвет
    Double screenSize; // Диагональ экрана
    String os; // Операционная система
    int hdd; // Объем жесткого диска
    int ram; // Объем оперативной памяти
    Double price; // Цена

    @Override
    public String toString() {
        return "Модель: " + model + "\n"
                + "Производитель: " + brand + "\n"
                + "Цвет: " + colour + "\n"
                + "Диагональ экрана: " + screenSize + "\n"
                + "Операционная система: " + os + "\n"
                + "Объем жесткого диска: " + hdd + " GB\n"
                + "Объем оперативной памяти: " + ram + " GB\n"
                + "Цена: " + price + " руб.";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Notebook)) {
            return false;
        }
        Notebook notebook = (Notebook) obj;
        return model.equals(notebook.model) && brand.equals(notebook.brand) && colour.equals(notebook.colour)
                && screenSize.equals(notebook.screenSize) && os.equals(notebook.os) && hdd == notebook.hdd
                && ram == notebook.ram && price.equals(notebook.price);
    }

    @Override
    public int hashCode() {
        return model.hashCode() + 9*brand.hashCode() + 12*colour.hashCode() + 17*screenSize.hashCode() + 8*os.hashCode()
                + 15*price.hashCode();
    }
}


