# SOAP

When the client is created, to avoid errors in compilation for duplicate classes, the path must be changed<br/>
`<configuration>`<br/>
    `<sourceDestDir>${project.build.sourceDirectory}</sourceDestDir>`<br/>
`</configuration>`<br/><br/>

<img src="img/SOAPclient.PNG" data-canonical-src="img/SOAPclient.PNG" />


The variable used on an implemented class must be PRIVATE


    
    private int id;
    private String title, director, year;

    public Movie(int id, String title, String director, String year) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.year = year;
    }
