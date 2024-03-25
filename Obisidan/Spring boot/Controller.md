

```

@RestController  
public class FunRestController {  
  
   @GetMapping("/")  
   public String sayHello(){  
      return "Hello World";  
   }
}

```