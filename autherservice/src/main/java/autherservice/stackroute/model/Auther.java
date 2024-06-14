package autherservice.stackroute.model;

public class Auther {

    int numFound;
    int start;
    Docs[] docs;

    public int getNumFound() {
        return numFound;
    }

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public Docs[] getDocs() {
        return docs;
    }

    public void setDocs(Docs[] docs) {
        this.docs = docs;
    }
}
