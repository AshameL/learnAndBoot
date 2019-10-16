### jdk采用基于观察者模式的委派事件模型，
即java组件所发生的事件并不是由引发事件的对象自己来负责处理，而是委派给独立的事件处理对象负责。

java事件机制的三种角色：

    * Event Eource 事件源，发起事件的主体。
    * Event Object 事件状态对象，传递的信息载体，就好比 Observer.update中的参数。
    可以是事件源本身，一般作为参数存在于listener方法中。
    
    * Event Listener 事件监听器。 

### springboot的事件机制参考JDK

