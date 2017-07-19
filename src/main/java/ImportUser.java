class ImportUser {

    final String givenName;
    final String familyName;
    final String email;
    final Integer employeeNumber;
    final String managerEmail;

    ImportUser(String givenName, String familyName, String email, Integer employeeNumber, String managerEmail) {
        this.givenName = givenName;
        this.familyName = familyName;
        this.email = email;
        this.employeeNumber = employeeNumber;
        this.managerEmail = managerEmail;
    }

    static final ImportUser[] IMPORT_USERS = {
            new ImportUser("Big", "Boss", "bb@example.com", null, null),
            new ImportUser("Vinnie", "Stetson", "VStetson@example.com", 1, "JDaughtery@example.com"),
            new ImportUser("Efren", "Pencil", "EPencil@example.com", 9, null),
        null,
            new ImportUser("Mary", "Tijerina", "MTijerina@example.com", 9, "HGraboski@example.com"),
            new ImportUser("Shawnta", "Lam", "SLam@example.com", null, "bb@example.com"),
            new ImportUser("Hilma", "Graboski", "HGraboski@example.com", 11, "FMatts@example.com"),
            new ImportUser("Ceola", "Kosek", "CKosek@example.com", 12, "EPencil@example.com"),
            new ImportUser("Vivien", "Poltrock", "VPoltrock@example.com", 13, "EPencil@example.com"),
            new ImportUser("Ernest", "Mccreadie", "EMccreadie@example.com", 14, "FMatts@example.com"),
            new ImportUser("Nga", "Urhahn", "NUrhahn@example.com", 2, "bb@example.com"),
            new ImportUser(null, "Beyrer", "DBeyrer@example.com", 15, "FMatts@example.com"),
            new ImportUser("Nannette", "Stupka", "NStupka@example.com", 16, "NUrhahn@example.com"),
            new ImportUser("Jada", "Peppler", "JPeppler@example.com", 17, "ktrone@example.com"),
            new ImportUser("Newton", "Mazar", "NMazar@example.com", 18, "ktrone@example.com"),
            new ImportUser("Cole", null, "CMcclaim@example.com", 19, "NUrhahn@example.com"),
            new ImportUser("Caryn", "Kusuma", "CKusuma@example.com", 20, "ktrone@example.com"),
            new ImportUser("Fredia", "Matts", "FMatts@example.com", null, "SLam@example.com"),
            new ImportUser("Marita", "Bezdicek", "MBezdicek@example.com", 3, "HGethers@example.com"),
            new ImportUser("Reina", "Sekulski", "RSekulski@example.com", 22, "HGethers@example.com"),
            new ImportUser("Rafael", "Neault", "RNeault@example.com", 23, "NUrhahn@example.com"),
            new ImportUser("Rodrick", "Castelluccio", "RCastelluccio@example.com", 24, "NUrhahn@example.com"),
            new ImportUser("Ignacio", "Nicol", "INicol@example.com", 25, "SLam@example.com"),
            new ImportUser("Marivel", "Prys", null, 27, "SLam@example.com"),
            new ImportUser("Robert", "Sehrt", "RSehrt@example.com", 27, "MTindle@example.com"),
            new ImportUser("Isobel", "Macalma", "IMacalma@example.com", 28, "ZAndrango@example.com"),
            new ImportUser("Katherina", "Trone", "KTrone@example.com", 4, "RSpiry@example.com"),
            new ImportUser("Cherish", "Casazza", "ktrone@example.com", null, "SLam@example.com"),
            new ImportUser("Anabel", "Thayne", "AThayne@example.com", 30, "INicol@example.com"),
            new ImportUser("Tristan", "Paalan", "TPaalan@example.com", 31, "INicol@example.com"),
            new ImportUser("Alden", "Vertz", "AVertz@example.com", 32, "INicol@example.com"),
            new ImportUser("Novella", "Clerkley", "NClerkley@example,com", 33, "NUrhahn@example.com"),
            new ImportUser("Joanne", "Blystone", "JBlystone@example.com", 34, "RSpiry@example.com"),
            new ImportUser("Tobias", "Hedge", "THedge@example.com", 35, "MTindle@example.com"),
            new ImportUser("Ira", "Debro", "IDebro@example.com", 5, "RSpiry@example.com"),
            new ImportUser("Natalya", "Kustes", "NKustes@example.com", 36, "MTindle@example.com"),
            new ImportUser("Rodney", "Spiry", "RSpiry@example.com", null, "RJacobitz@example.com"),
            new ImportUser("Helen", "Churner", "HChurner@example.com", 38, "ZAndrango@example.com"),
            new ImportUser("Boris", "Shumway", "BShumway@example.com", 39, "ZAndrango@example.com"),
            new ImportUser("Melvina", "Tindle", "MTindle@example.com", 40, "bb@example.com"),
            new ImportUser("Latina", "Zaner", "LZaner@example.com", 41, "ktrone@example.com"),
            new ImportUser("Johana", "Adu", "JAdu@example.com", 42, "CWiles@example.com"),
            new ImportUser("Zetta", "Andrango", "ZAndrango@example.com", 6, "CSiering@example.com"),
            new ImportUser("Blair", "Ruley", "BRuley@example.com", 43, "ktrone@example.com"),
            new ImportUser("Hallie", "Gethers", "HGethers@example.com", 44, "VOtts@example.com"),
            new ImportUser("Cristy", "Tankersley", "ZAndrango@example.com", null, "CWiles@example.com"),
            new ImportUser("Caprice", "Siering", "CSiering@example.com", null, "CWiles@example.com"),
            new ImportUser("Jesusita", "Galer", "JGaler@example.com", 47, "CSiering@example.com"),
            new ImportUser("Florentina", "Louissant", "FLouissant@example.com", null, "CSiering@example.com"),
            new ImportUser("Mignon", "Velarde", "MVelarde@example.com", 49, "VOtts@example.com"),
            new ImportUser("Erika", "Zachry", "EZachry@example.com", 7, "VOtts@example.com"),
            new ImportUser("Jackeline", "Daughtery", "JDaughtery@example.com", 50, "FGarrean@example.com"),
            new ImportUser("Francesca", "Garrean", "FGarrean@example.com", 51, "NTanker@example.com"),
            new ImportUser("Nelson", "Tanker", "NTanker@example.com", 52, "VStetson@example.com"),
            new ImportUser("Carolyn", "Sund", "CSund@example.com", 53, "RJacobitz@example.com"),
            new ImportUser("Verda", "Otts", "VOtts@example.com", 54, "MTindle@example.com"),
            new ImportUser("Casimira", "Wiles", "CWiles@example.com", 55, "bb@example.com"),
            new ImportUser("Rebecca", "Jacobitz", "RJacobitz@example.com", 56, "bb@example.com"),
    };
}