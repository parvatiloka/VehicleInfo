package test.java.exampleFileReader.service;

import exampleFileReader.enums.MimeType;
import main.java.exampleFileReader.pojo.FileDetails;
import main.java.exampleFileReader.pojo.VehicleDetails;
import main.java.exampleFileReader.service.FileReaderService;
import main.java.exampleFileReader.service.FileReaderServiceImpl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class FileReaderServiceImplTest {

    @Rule
    public TemporaryFolder folderLevel1 = new TemporaryFolder();

    @Rule
    public TemporaryFolder folderLevel3 = new TemporaryFolder();
    private File file1;
    private File file2;
    private File file3;
    private File file4;
    private File file5;
    private File levelOneFolder;
    private File levelTwoFolder;
    @Rule
    public TemporaryFolder emptyFolder = new TemporaryFolder();

    private FileReaderService fileReaderService;

    private static String MIMETYPE_TXT = "text/plain";

    @Before
    public void setUp() throws Exception {

        file1 = folderLevel3.newFile("testfile1.csv");
        levelOneFolder = folderLevel3.newFolder("levelOneFolder");
        levelTwoFolder = folderLevel3.newFolder("levelOneFolder","levelTwoFolder");
        file2 = folderLevel3.newFile("levelOneFolder/testfile2.csv");
        file3 = folderLevel3.newFile("levelOneFolder/levelTwoFolder/testfile3.csv");
        file4 = folderLevel3.newFile("levelOneFolder/levelTwoFolder/testfile4.txt");
        file5 = folderLevel3.newFile("levelOneFolder/levelTwoFolder/testfile5.xls");

        FileWriter fileWriter = new FileWriter(file1);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print("V123DPR,Peugeot,green");
        printWriter.close();


        FileWriter fileWriter3 = new FileWriter(file3);
        PrintWriter printWriter3 = new PrintWriter(fileWriter3);
        printWriter3.print("P1LOT,BMW,black");
        printWriter3.close();

        FileWriter fileWriter5 = new FileWriter(file5);
        PrintWriter printWriter5 = new PrintWriter(fileWriter5);
        printWriter5.print("YS59ABZ BMW BLUE");
        printWriter5.close();

        fileReaderService = new FileReaderServiceImpl();
    }


    @Test
    public void testOneDirectoryDown() throws Exception {
        File fileLevel1 = folderLevel1.newFile("level1.csv");
        FileWriter fileWriter = new FileWriter(fileLevel1);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print("V123DPR,Peugeot,green");
        printWriter.close();
        assertTrue(fileLevel1.exists());
        List<FileDetails> fileDetailsList = fileReaderService.getFileContents(folderLevel1.getRoot().getPath());
        assertEquals(1, fileDetailsList.size());
    }


    @Test
    public void testThreeDirectoriesDown() throws Exception {
        List<FileDetails> fileDetailsList = fileReaderService.getFileContents(folderLevel3.getRoot().getPath());
        assertEquals(3, fileDetailsList.size());
    }

    @Test
    public void testEmptyDirectory() throws Exception {
        List<FileDetails> fileDetailsList = fileReaderService.getFileContents(emptyFolder.getRoot().getPath());
        assertEquals(0, fileDetailsList.size());
    }

    @Test
    public void testMimeTypeCSV () throws Exception {
        List<FileDetails> fileDetailsList = fileReaderService.getFileContents(folderLevel3.getRoot().getPath());
        FileDetails fileDetails = fileReaderService.getFileDetailsFromFile("testfile1.csv");
        assertEquals(MimeType.CSV,fileDetails.getMimeType());
    }

    @Test
    public void testMimeTypeTxt () throws Exception {
        List<FileDetails> fileDetailsList = fileReaderService.getFileContents(folderLevel3.getRoot().getPath());
        assertNull(fileReaderService.getFileDetailsFromFile("testfile2.csv"));
    }

    @Test
    public void testMimeTypeExcel() throws Exception {
        List<FileDetails> fileDetailsList = fileReaderService.getFileContents(folderLevel3.getRoot().getPath());
        FileDetails fileDetails = fileReaderService.getFileDetailsFromFile("testfile5.xls");
        assertEquals(MimeType.EXCEL,fileDetails.getMimeType());
    }


    @Test
    public void testVehicleDetailsAddedCSV() throws Exception {
        List<FileDetails> fileDetailsList = fileReaderService.getFileContents(folderLevel3.getRoot().getPath());
        VehicleDetails vehicleDetails = fileReaderService.getVehicleDetailsFromFile("testfile3.csv");
        assertEquals("P1LOT", vehicleDetails.getRegNo());
        assertEquals("BMW", vehicleDetails.getMake());
        assertEquals("BLACK", vehicleDetails.getColour());
    }

    @Test
    public void testVehicleDetailsAddedXLS() throws Exception {
        List<FileDetails> fileDetailsList = fileReaderService.getFileContents(folderLevel3.getRoot().getPath());
        VehicleDetails vehicleDetails = fileReaderService.getVehicleDetailsFromFile("testfile5.xls");
        assertEquals("YS59ABZ", vehicleDetails.getRegNo());
        assertEquals("BMW", vehicleDetails.getMake());
        assertEquals("BLUE", vehicleDetails.getColour());
    }





}
