import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by bangjinhyuk on 2021/11/04.
 */
public class tax {
    public static void main(String[] args) throws IOException {
        List<taxDTO> list = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream("/Users/bangjinhyuk/Documents/개발/Git/tax/src/exam.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            int rowindex=0;
            int columnindex=0;
            //시트 수 (첫번째에만 존재하므로 0을 준다)
            //만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
            XSSFSheet sheet=workbook.getSheetAt(0);
            //행의 수
            int rows=sheet.getPhysicalNumberOfRows();
            for(rowindex=0;rowindex<rows;rowindex++){
                //행을읽는다
                XSSFRow row=sheet.getRow(rowindex);
                if(row !=null){
                    //셀의 수
                    int cells=row.getPhysicalNumberOfCells();
                    for(columnindex=0; columnindex<=cells; columnindex++){
                        //셀값을 읽는다
                        XSSFCell cell=row.getCell(columnindex);
                        String value="";
                        //셀이 빈값일경우를 위한 널체크
                        if(cell==null){
                            continue;
                        }else{
                            //타입별로 내용 읽기
                            switch (cell.getCellType()){
                                case XSSFCell.CELL_TYPE_FORMULA:
                                    value=cell.getCellFormula();
                                    break;
                                case XSSFCell.CELL_TYPE_NUMERIC:
                                    value=cell.getNumericCellValue()+"";
                                    break;
                                case XSSFCell.CELL_TYPE_STRING:
                                    value=cell.getStringCellValue()+"";
                                    break;
                                case XSSFCell.CELL_TYPE_BLANK:
                                    value=cell.getBooleanCellValue()+"";
                                    break;
                                case XSSFCell.CELL_TYPE_ERROR:
                                    value=cell.getErrorCellValue()+"";
                                    break;
                            }
                        }
                        System.out.println(rowindex+"번 행 : "+columnindex+"번 열 값은: "+value);
                        list.add(new taxDTO(Double.parseDouble(value)));
                    }

                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        writeExcelFile(list);
    }
    public static void writeExcelFile(List<taxDTO> list) throws EncryptedDocumentException, IOException {
        String filePath = "result.xlsx";    // 저장할 파일 경로

        FileOutputStream fos = new FileOutputStream(filePath);

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("studentList");    // sheet 생성

        XSSFRow curRow;

        curRow = sheet.createRow(0);    // row 생성
        curRow.createCell(0).setCellValue("차인 지급액");    // row에 각 cell 저장
        curRow.createCell(1).setCellValue("지급액");
        curRow.createCell(2).setCellValue("소득세");
        curRow.createCell(3).setCellValue("지방 소득세");
        curRow.createCell(4).setCellValue("지급액2");
        curRow.createCell(5).setCellValue("소득세2");
        curRow.createCell(6).setCellValue("지방 소득세2");

        int row = list.size();    // list 크기
        for (int i = 0; i < row; i++) {
            curRow = sheet.createRow(i+1);    // row 생성
            curRow.createCell(0).setCellValue(list.get(i).getLoanPaymentAmount());    // row에 각 cell 저장
            curRow.createCell(1).setCellValue(list.get(i).getTotal());    // row에 각 cell 저장
            curRow.createCell(2).setCellValue(list.get(i).getIncomeTax());
            curRow.createCell(3).setCellValue(list.get(i).getLocalIncomeTax());
            curRow.createCell(4).setCellValue(list.get(i).getTotal2());    // row에 각 cell 저장
            curRow.createCell(5).setCellValue(list.get(i).getIncomeTax2());
            curRow.createCell(6).setCellValue(list.get(i).getLocalIncomeTax2());
        }

        workbook.write(fos);
        fos.close();
    }
}
