package covid.service;

import covid.Zip;
import covid.repository.ZipRepository;

import java.nio.file.Path;
import java.util.List;

public class ZipService {

    private ZipRepository zipRepository;

    public ZipService(ZipRepository zipRepository) {
        this.zipRepository = zipRepository;
    }

    public void insertZipFromFile(Path path) {
        List<Zip> zipListFromFile = zipRepository.makeZipList(path);
        zipRepository.insertZip(zipListFromFile);
    }
}
