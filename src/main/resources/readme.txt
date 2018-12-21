url:可在yml中server:
                servlet:
                    context-path: /girl
     为1级url;
     controller级别加requestMapping为第二级别url;
     method级别加requestMapping为第三级别url。
 @value ：可在类中动态的读取配置信息  @Value(${cupSize})
 @PathVariable : 获取url中的指定数据/.../中间的值
 @RequestParam : 获取请求参数的值?=xxx这种传统的值,不需要参数可以写rquirde=false,设置默认数值:defaultValue="0".
 @GetMapping： 组合注解，@RequestMapping + method=RequestMethod=GET
 @验证年龄小于18岁。在model类Girl的age属性上加@Min注解。在controller类的方法上对girl参数加@Valid注解，并增加BindingResult对象，并通过该对象打印错误信息。
 @Slf4j ： 可以加此注解，而不用每次都写private final Logger logger =LoggerFactor.getLogger(XXX.class);