import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в наш магазин! Для того, чтобы выбрать подходящий ноутбук, используйте фильтр " +
                "и укажите интересующие вас параметры\n");
        Scanner userInput = new Scanner(System.in);
        Map<Integer, String> userResult = new HashMap<>();
        boolean search = true;
        while (search) {
            System.out.println("Выберете пункт меню:\n");
            printFilter(filter());
            String filterPoint = userInput.nextLine();
            switch (filterPoint) {
                case "1":
                    String result1 = searchBrand();
                    userResult.put(1, result1);
                    System.out.println();
                    break;
                case "2":
                    String result2 = searchColor();
                    userResult.put(2, result2);
                    System.out.println();
                    break;
                case "3":
                    String result3 = searchScreenSize();
                    userResult.put(3, result3);
                    System.out.println();
                    break;
                case "4":
                    String result4 = searchOS();
                    userResult.put(4, result4);
                    System.out.println();
                    break;
                case "5":
                    String result5 = searchHDD();
                    userResult.put(5, result5);
                    System.out.println();
                    break;
                case "6":
                    String result6 = searchRAM();
                    userResult.put(6, result6);
                    System.out.println();
                    break;
                case "7":
                    String result7 = searchMaxPrice();
                    userResult.put(7, result7);
                    System.out.println();
                    break;
                case "8":
                    Set<Notebook> searchResult = searchNotebook(userResult);
                    if (searchResult.isEmpty()) {
                        System.out.println("По вашему запросу ничего не найдено");
                        System.out.println();
                    } else {
                        printMyStore(searchResult);
                    }
                    userResult.clear();
                    break;
                case "9":
                    printMyStore(myStore());
                    System.out.println("Хотите воспользоваться поиском?\n");
                    break;
                case "10":
                    search = false;
                    break;
            }
        }
    }

    static Set<Notebook> myStore() {
        Notebook notebook1 = new Notebook();
        notebook1.model = "AA3697_3";
        notebook1.brand = "LENOVO";
        notebook1.colour = "Blue";
        notebook1.screenSize = 17.3;
        notebook1.os = "Windows 11";
        notebook1.hdd = 512;
        notebook1.ram = 16;
        notebook1.price = 95800.00;

        Notebook notebook2 = new Notebook();
        notebook2.model = "AA9800_C";
        notebook2.brand = "LENOVO";
        notebook2.colour = "Black";
        notebook2.screenSize = 15.6;
        notebook2.os = "Windows 10";
        notebook2.hdd = 512;
        notebook2.ram = 18;
        notebook2.price = 75200.00;

        Notebook notebook3 = new Notebook();
        notebook3.model = "CO_9786";
        notebook3.brand = "ASUS";
        notebook3.colour = "Black";
        notebook3.screenSize = 17.3;
        notebook3.os = "Windows 11";
        notebook3.hdd = 1000;
        notebook3.ram = 32;
        notebook3.price = 151300.00;

        Notebook notebook4 = new Notebook();
        notebook4.model = "C1_0096";
        notebook4.brand = "ASUS";
        notebook4.colour = "Grey";
        notebook4.screenSize = 14.1;
        notebook4.os = "Linux";
        notebook4.hdd = 256;
        notebook4.ram = 8;
        notebook4.price = 52100.00;

        Notebook notebook5 = new Notebook();
        notebook5.model = "32_9875hw";
        notebook5.brand = "HUAWEI";
        notebook5.colour = "Silver";
        notebook5.screenSize = 14.1;
        notebook5.os = "Windows 10";
        notebook5.hdd = 512;
        notebook5.ram = 16;
        notebook5.price = 57350.00;

        Notebook notebook6 = new Notebook();
        notebook6.model = "asm_035_df";
        notebook6.brand = "SAMSUNG";
        notebook6.colour = "White";
        notebook6.screenSize = 17.3;
        notebook6.os = "Без ОС";
        notebook6.hdd = 1000;
        notebook6.ram = 32;
        notebook6.price = 98700.00;

        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(notebook1);
        notebooks.add(notebook2);
        notebooks.add(notebook3);
        notebooks.add(notebook4);
        notebooks.add(notebook5);
        notebooks.add(notebook6);
        return notebooks;
    }

    static void printMyStore(Set<Notebook> set) {
        for (Notebook notebook: set) {
            System.out.println(notebook);
            System.out.println();
        }
    }

    static Map<Integer, String> filter() {
        Map <Integer, String> filter = new HashMap<>();
        filter.put(1, "Фирма-производитель");
        filter.put(2, "Цвет");
        filter.put(3, "Диагональ экрана");
        filter.put(4, "Операционная система");
        filter.put(5, "Объем жесткого диска");
        filter.put(6, "Объем оперативной памяти");
        filter.put(7, "Максимальная цена");
        filter.put(8, "Начать поиск");
        filter.put(9, "Показать все модели");
        filter.put(10, "Выход");
        return filter;
    }

    static void printFilter(Map<Integer, String> map) {
        for (int i = 1; i <= map.size(); i++) {
            System.out.println(i + ": " + map.get(i));
        }
        System.out.println();
        System.out.println("Введите номер пункта меню:\n");
    }

    static String searchBrand() {
        System.out.println("""
                У нас в наличии:
                ASUS
                HUAWEI
                LENOVO
                SAMSUNG
                Напишите производителя ниже""");
        Scanner inputBrand = new Scanner(System.in);
        return inputBrand.nextLine();
    }

    static String searchColor() {
        System.out.println("""
                Доступные цвета:
                Black
                Blue
                Grey
                Silver
                White
                Напишите цвет ниже""");
        Scanner inputColor = new Scanner(System.in);
        return inputColor.nextLine();
    }

    static String searchScreenSize() {
        System.out.println("""
                Выберете диагональ экрана:
                17.3
                15.6
                14.1
                Напишите значение ниже""");
        Scanner inputScreenSize = new Scanner(System.in);
        return inputScreenSize.nextLine();
    }

    static String searchOS() {
        System.out.println("""
                Выберете операционную систему:
                Без OS
                Linux
                Windows 10
                Windows 11
                Напишите операционную систему ниже""");
        Scanner inputOS = new Scanner(System.in);
        return inputOS.nextLine();
    }

    static String searchHDD() {
        System.out.println("""
                Выберете объем жесткого диска:
                256
                512
                1000
                Напишите значение ниже""");
        Scanner inputHDD = new Scanner(System.in);
        return inputHDD.nextLine();
    }

    static String searchRAM() {
        System.out.println("""
                Выберете объем оперативной памяти:
                8
                16
                18
                32
                Напишите значение ниже""");
        Scanner inputRAM = new Scanner(System.in);
        return inputRAM.nextLine();
    }

    static String searchMaxPrice() {
        System.out.println("Укажите максимальную цену:\n");
        Scanner inputMaxPrice = new Scanner(System.in);
        return inputMaxPrice.nextLine();
    }

    static Set<Notebook> searchNotebook(Map<Integer, String> map) {
        if (map.isEmpty()) return myStore();
        Set<Notebook> notebooks = myStore();
        Set<Notebook> set = new HashSet<>(notebooks);
        for (Notebook notebook: notebooks) {
            if (map.containsKey(1) && !(notebook.brand.equalsIgnoreCase(map.get(1)))) {
                set.remove(notebook);
            }
        }
        for (Notebook notebook: notebooks) {
            if (map.containsKey(2) && !(notebook.colour.equalsIgnoreCase(map.get(2)))) {
                set.remove(notebook);
            }
        }
        for (Notebook notebook: notebooks) {
            if (map.containsKey(3) && notebook.screenSize != Double.parseDouble(map.get(3))) {
                set.remove(notebook);
            }
        }
        for (Notebook notebook: notebooks) {
            if (map.containsKey(4) && !(notebook.os.equalsIgnoreCase(map.get(4)))) {
                set.remove(notebook);
            }
        }
        for (Notebook notebook: notebooks) {
            if (map.containsKey(5) && notebook.hdd != Integer.parseInt(map.get(5))) {
                set.remove(notebook);
            }
        }
        for (Notebook notebook: notebooks) {
            if (map.containsKey(6) && notebook.ram != Integer.parseInt(map.get(6))) {
                set.remove(notebook);
            }
        }
        for (Notebook notebook: notebooks) {
            if (map.containsKey(7) && notebook.price > Double.parseDouble(map.get(7))) {
                set.remove(notebook);
            }
        }

        return set;
    }
}