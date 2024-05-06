
```
   
	// hvata StudentNotFoundException
	@ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc)
    {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // greska koja se propagira i koja ce biti prevedena preko jacksona i status code
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }







// hvata bilo koji exception koji nije do tad uhvatio
  @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc)
    {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // greska koja se propagira i koja ce biti prevedena preko jacksona i status code
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }



```



```
// rest/StudentErrorResponse.java


package rs.perica.demo.rest;

public class StudentErrorResponse {
// mora imati getter i setter, i konstruktor kako bi jackson radio
// kako treba u prevodjenju stvari

    private int status;
    private String message;
    private long timeStamp;

    public StudentErrorResponse()
    {

    }

    public StudentErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}

```




```
// studentnotfound exception

package rs.perica.demo.rest;

public class StudentNotFoundException extends RuntimeException{



    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
```