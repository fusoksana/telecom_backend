/**
 * Created by yurko on 23.10.17.
 */
 class ExportedFile {
   private String file;
    private String extention;

    public ExportedFile(String file, String extention) {
        this.file = file;
        this.extention = extention;
    }

    public String getFile() {
        return file;
    }

    public String getExtention() {
        return extention;
    }
}
