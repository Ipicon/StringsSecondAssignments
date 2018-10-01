
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int first = dna.indexOf("ATG",startIndex);
        if(first == -1)
            return dna.length();
        int last = dna.indexOf(stopCodon, first);
        if (last == -1 || (last-first)%3 != 0)
            return dna.length();
        return last;
    }
    public void testFindStopCodon(){
        int startIndex = 0;
        String dna = "HKMKCATGBDESVPTAAIOP";
        int gene = findStopCodon(dna, startIndex, "TAA");
        if(gene == dna.length())
            System.out.println("ERROR 1");
        dna = "HKMKCATGDESBVPTAGIOP";
        gene = findStopCodon(dna, startIndex, "TAG");
        if(gene == dna.length())
            System.out.println("ERROR 2");
        dna = "HKMKCATGBDESVPTGAIOP";
        gene = findStopCodon(dna, startIndex, "TGA");
        if(gene == dna.length())
            System.out.println("ERROR 3");
        dna = "HKMKCATGBDEVTAAIOP";
        gene = findStopCodon(dna, startIndex, "TAA");
        if(gene != dna.length())
            System.out.println("ERROR 4");
        dna = "HKMKCATBBDEVTAAIOP";
        gene = findStopCodon(dna, startIndex, "TAA");
        if(gene != dna.length())
            System.out.println("ERROR 5");  
        dna = "HKMKCATGBDEVTBBAIOP";
        gene = findStopCodon(dna, startIndex, "TAA");
        if(gene != dna.length())
            System.out.println("ERROR 6");    
        System.out.println("Testing Completed!");
    }
    public String findGene(String dna) {
        int atg = dna.indexOf("ATG");
        if (atg == -1) 
            return "";
        int taaCodon = findStopCodon(dna, atg, "TAA");
        int tagCodon = findStopCodon(dna, atg, "TAG");
        int tgaCodon = findStopCodon(dna, atg, "TGA");
        int minGene = 0;
        if(taaCodon == dna.length() || (tagCodon != dna.length() && tagCodon < taaCodon))
            minGene  = tagCodon;
        else
            minGene = taaCodon;
        if(minGene == dna.length() ||(tgaCodon != dna.length() && tgaCodon < minGene))
            minGene = tgaCodon;
        if (minGene == dna.length())
            return "";
        return dna.substring(atg,(minGene +3));
    }
    public void testFindGene() {
        String dna = "MPOMSOIDISNAIUNASD";
        String gene = findGene(dna);
        if(!gene.isEmpty())
            System.out.println("error");
        dna = "MPOMATGDISNAIUNASD";
        gene = findGene(dna);
        if(!gene.isEmpty())
            System.out.println("error");
        dna = findGene("MPOMATGDISNAITAASD");
        if(dna.isEmpty())
            System.out.println("error");
        dna = findGene("MPOMATGTAGNAIUNASD"); 
        if(dna.isEmpty())
            System.out.println("error");
        dna = findGene("MPOMATGDISTGAUNASD");
        if(dna.isEmpty())
            System.out.println("error");
        dna = findGene("MPOMATGDITTAGITAASDTGA");
        if(dna.isEmpty())
            System.out.println("error");
        dna = findGene("MPOMATGTTAAGNAIUNASD");
        if(!dna.isEmpty())
            System.out.println("error");
        System.out.println("RUN FINISHED!");
    }
    public void printAllGenes(String dna) {
        int startIndex = dna.indexOf("ATG");
        int atg = 0;
        String allGenes = "The dna is: "+ dna + ".\n" + "And the genes are: "; 
        while (true) {
             atg = dna.indexOf("ATG", startIndex);
             if(atg == -1)
                break;
             String gene = findGene(dna);
             allGenes = allGenes + gene + ".\n";
             startIndex = atg + 1;
        }
        System.out.println(allGenes);
    }
    public void printAllGenesTest() {
        printAllGenes("MPOMSOIDISNAIUNASD");
        printAllGenes("MPOMATGDISNAIUNASD");
        printAllGenes("MPOMATGDISNAITAASDMPOMATGDISNAITAASDMPOMATGDISNAITAASD");
        printAllGenes("MPOMATGTAGNAIUNASDMPOMATGTAGNAIUNASD");
        printAllGenes("MPOMATGDISTGAUNASD");
        printAllGenes("MPOMATGDITTAGITAASDTGAMPOMATGDITTAGITAASDTGAMPOMATGDITTAGITAASDTGAMPOMATGDITTAGITAASDTGA");
        printAllGenes("MPOMATGTTAAGNAIUNASD");
        System.out.println("RUN FINISHED!");
    }
    public int countGenes(String dna) {
        int startIndex = dna.indexOf("ATG");
        int atg = 0;
        int counter = 0;
        String allGenes = "There are:  "; 
        while (true) {
             atg = dna.indexOf("ATG", startIndex);
             if(atg == -1)
                break;
             String gene = findGene(dna);
             if(!gene.isEmpty())
                counter++;
             startIndex = atg + 1;
        }
        allGenes = allGenes + counter + " genes in the dna: " + dna + ".";
        System.out.println(allGenes);
        return counter;
    }
    public void printAllGenesTestNumbers() {
        countGenes("MPOMSOIDISNAIUNASD");
        countGenes("MPOMATGDISNAIUNASD");
        countGenes("MPOMATGDISNAITAASDMPOMATGDISNAITAASDMPOMATGDISNAITAASD");
        countGenes("MPOMATGTAGNAIUNASDMPOMATGTAGNAIUNASD");
        countGenes("MPOMATGDISTGAUNASD");
        countGenes("MPOMATGDITTAGITAASDTGAMPOMATGDITTAGITAASDTGAMPOMATGDITTAGITAASDTGAMPOMATGDITTAGITAASDTGA");
        countGenes("MPOMATGTTAAGNAIUNASD");
        System.out.println("RUN FINISHED!");
    }
}

