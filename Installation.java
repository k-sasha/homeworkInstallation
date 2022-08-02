package workWithFiles.installation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Installation {
    public static void main(String[] args) {
        File mainFile = new File("/Users/sasha/IdeaProjects/netologyCourse/Games");
        System.out.println("mainFile.canRead() " + mainFile.canRead());
        System.out.println("mainFile.canWrite() " + mainFile.canWrite());

        File dirSrc = new File("/Users/sasha/IdeaProjects/netologyCourse/Games/src");
        File dirRes = new File("/Users/sasha/IdeaProjects/netologyCourse/Games/res");
        File dirSaveGames = new File("/Users/sasha/IdeaProjects/netologyCourse/Games/savegames");
        File dirTemp = new File("/Users/sasha/IdeaProjects/netologyCourse/Games/temp");

        File dirMain = new File("/Users/sasha/IdeaProjects/netologyCourse/Games/src/main");
        File dirTest = new File("/Users/sasha/IdeaProjects/netologyCourse/Games/src/test");

        File fileMain = new File("/Users/sasha/IdeaProjects/netologyCourse/Games/src/main/Main.java");
        File fileUtils = new File("/Users/sasha/IdeaProjects/netologyCourse/Games/src/main/Utils.java");

        File dirDrawables = new File("/Users/sasha/IdeaProjects/netologyCourse/Games/res/drawables");
        File dirVectors = new File("/Users/sasha/IdeaProjects/netologyCourse/Games/res/vectors");
        File dirIcons = new File("/Users/sasha/IdeaProjects/netologyCourse/Games/res/icons");

        File fileTemp = new File("/Users/sasha/IdeaProjects/netologyCourse/Games/temp/temp.txt");

        File[] directories = {dirSrc, dirRes, dirSaveGames, dirTemp, dirMain, dirTest,
                dirDrawables, dirVectors, dirIcons};

        File[] files = {fileMain, fileUtils, fileTemp};

        StringBuilder log = new StringBuilder();
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy, hh:mm");


        for (File directory : directories) {
            if (directory.mkdir()) {
                log.append("directory ").append(directory.getName()).append(" is created ").append(dateTime.format(formatter)).append("\n");
            } else {
                log.append("directory ").append(directory.getName()).append(" is not created ").append(dateTime.format(formatter)).append("\n");
            }
        }

        for (File file : files) {
            try {
                if (file.createNewFile()) {
                    log.append("file ").append(file.getName()).append(" is created ").append(dateTime.format(formatter)).append("\n");
                } else {
                    log.append("file ").append(file.getName()).append(" is not created ").append(dateTime.format(formatter)).append("\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (FileWriter writer = new FileWriter(fileTemp)) {
            writer.write(log.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Done!");
    }
}
