class ImportUser {

    final String givenName;
    final String familyName;
    final String email;
    final Integer employeeNumber;

    ImportUser(String givenName, String familyName, String email, Integer employeeNumber) {
        this.givenName = givenName;
        this.familyName = familyName;
        this.email = email;
        this.employeeNumber = employeeNumber;
    }

    static final ImportUser[] IMPORT_USERS = {
        new ImportUser("Big", "Boss", "bb@example.com", null),
        new ImportUser("Vinnie", "Stetson", "VStetson@example.com", 1),
        new ImportUser("Efren", "Pencil", "EPencil@example.com", 9),
        null,
        new ImportUser("Mary", "Tijerina", "MTijerina@example.com", 9),
        new ImportUser("Shawnta", "Lam", "SLam@example.com", null),
        new ImportUser("Hilma", "Graboski", "HGraboski@example.com", 11),
        new ImportUser("Ceola", "Kosek", "CKosek@example.com", 12),
        new ImportUser("Vivien", "Poltrock", "VPoltrock@example.com", 13),
        new ImportUser("Ernest", "Mccreadie", "EMccreadie@example.com", 14),
        new ImportUser("Nga", "Urhahn", "NUrhahn@example.com", 2),
        new ImportUser(null, "Beyrer", "DBeyrer@example.com", 15),
        new ImportUser("Nannette", "Stupka", "NStupka@example.com", 16),
        new ImportUser("Jada", "Peppler", "JPeppler@example.com", 17),
        new ImportUser("Newton", "Mazar", "NMazar@example.com", 18),
        new ImportUser("Cole", null, "CMcclaim@example.com", 19),
        new ImportUser("Caryn", "Kusuma", "CKusuma@example.com", 20),
        new ImportUser("Fredia", "Matts", "FMatts@example.com", null),
        new ImportUser("Marita", "Bezdicek", "MBezdicek@example.com", 3),
        new ImportUser("Reina", "Sekulski", "RSekulski@example.com", 22),
        new ImportUser("Rafael", "Neault", "RNeault@example.com", 23),
        new ImportUser("Rodrick", "Castelluccio", "RCastelluccio@example.com", 24),
        new ImportUser("Ignacio", "Nicol", "INicol@example.com", 25),
        new ImportUser("Marivel", "Prys", null, 26),
        new ImportUser("Robert", "Sehrt", "RSehrt@example.com", 27),
        new ImportUser("Isobel", "Macalma", "IMacalma@example.com", 28),
        new ImportUser("Katherina", "Trone", "KTrone@example.com", 4),
        new ImportUser("Cherish", "Casazza", "ktrone@example.com", null),
        new ImportUser("Anabel", "Thayne", "AThayne@example.com", 30),
        new ImportUser("Tristan", "Paalan", "TPaalan@example.com", 31),
        new ImportUser("Alden", "Vertz", "AVertz@example.com", 32),
        new ImportUser("Novella", "Clerkley", "NClerkley@example,com", 33),
        new ImportUser("Joanne", "Blystone", "JBlystone@example.com", 34),
        new ImportUser("Tobias", "Hedge", "THedge@example.com", 35),
        new ImportUser("Ira", "Debro", "IDebro@example.com", 5),
        new ImportUser("Natalya", "Kustes", "NKustes@example.com", 36),
        new ImportUser("Rodney", "Spiry", "RSpiry@example.com", null),
        new ImportUser("Helen", "Churner", "HChurner@example.com", 38),
        new ImportUser("Boris", "Shumway", "BShumway@example.com", 39),
        new ImportUser("Melvina", "Tindle", "MTindle@example.com", 40),
        new ImportUser("Latina", "Zaner", "LZaner@example.com", 41),
        new ImportUser("Johana", "Adu", "JAdu@example.com", 42),
        new ImportUser("Zetta", "Andrango", "ZAndrango@example.com", 6),
        new ImportUser("Blair", "Ruley", "BRuley@example.com", 43),
        new ImportUser("Hallie", "Gethers", "HGethers@example.com", 44),
        new ImportUser("Cristy", "Tankersley", "ZAndrango@example.com", null),
        new ImportUser("Caprice", "Siering", "CSiering@example.com", null),
        new ImportUser("Jesusita", "Galer", "JGaler@example.com", 47),
        new ImportUser("Florentina", "Louissant", "FLouissant@example.com", null),
        new ImportUser("Mignon", "Velarde", "MVelarde@example.com", 49),
        new ImportUser("Erika", "Zachry", "EZachry@example.com", 7),
        new ImportUser("Jackeline", "Daughtery", "JDaughtery@example.com", 50),
        new ImportUser("Francesca", "Garrean", "FGarrean@example.com", 51),
        new ImportUser("Nelson", "Tanker", "NTanker@example.com", 52),
        new ImportUser("Carolyn", "Sund", "CSund@example.com", 53),
        new ImportUser("Verda", "Otts", "VOtts@example.com", 54),
        new ImportUser("Casimira", "Wiles", "CWiles@example.com", 55),
        new ImportUser("Rebecca", "Jacobitz", "RJacobitz@example.com", 56),
    };
}