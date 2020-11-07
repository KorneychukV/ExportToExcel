package ru.vkorneychuk;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import ru.vkorneychuk.POJO.Car;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExportToExcel {

    public static void main(String[] args) {
        // создание самого excel файла в памяти
        HSSFWorkbook excelFile = new HSSFWorkbook();
        // создание листа с названием "Просто лист"
        HSSFSheet reportSheet = excelFile.createSheet("Отчёт");
        // заполнение списка данными
        List<Car> carList = fillData();
        // счетчик для строк
        int rowNum = 0;

        // создание строки
        Row row = reportSheet.createRow(rowNum);
        // заполнение строки
        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("Марка");
        row.createCell(2).setCellValue("Модель");
        row.createCell(3).setCellValue("Гос. номер");

        // заполняем лист данными
        for (Car car : carList) {
            createSheetHeader(reportSheet, ++rowNum, car);
        }

        // записываем созданный в памяти Excel документ в файл
        try (FileOutputStream out = new FileOutputStream(new File("./excelTest.xls"))) {
            excelFile.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel файл успешно создан!");
    }

    // заполнение строки (rowNum) определенного листа (sheet)
    // данными  из dataModel созданного в памяти Excel файла
    private static void createSheetHeader(HSSFSheet sheet, int rowNum, Car car) {
        Row row = sheet.createRow(rowNum);

        row.createCell(0).setCellValue(car.getId());
        row.createCell(1).setCellValue(car.getMark());
        row.createCell(2).setCellValue(car.getModel());
        row.createCell(3).setCellValue(car.getNumber());
    }

    // заполняем список рандомными данными
    // в реальных приложениях данные будут из БД или интернета
    private static List<Car> fillData() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(1, "Renault", "Logan", "х152сс"));
        carList.add(new Car(2, "Kia", "Cee'd", "с896ип"));
        carList.add(new Car(3, "Kia", "Rio", "в475лс"));

        return carList;
    }
}
