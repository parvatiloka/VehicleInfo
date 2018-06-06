package main.java.exampleFileReader.service;

import main.java.exampleFileReader.pojo.FileDetails;
import main.java.exampleFileReader.pojo.VehicleDetails;

import java.util.List;


public interface FileReaderService {

    /***
     * Stores the details of a file from a particular path in a list of fileDetails
     * only files which have mimetypes for csv and excel are currently stored
     * @param path
     * @return List of fileDetails
     */
    public List<FileDetails> getFileContents(String path);

    /**
     * Get the file details of a named file
     * @param filename
     * @return fileDetails of a file
     */
    public FileDetails getFileDetailsFromFile(String filename);

    /**
     * Get the vehicle details stored in a file
     * @param filename
     * @return vehicle details in a file
     */
    public VehicleDetails getVehicleDetailsFromFile(String filename);

}
