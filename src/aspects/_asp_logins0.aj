package aspects;

import larva.*;
public aspect _asp_logins0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_logins0.initialize();
}
}
before () : (call(* *.viewAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_logins0.lock){

_cls_logins0 _cls_inst = _cls_logins0._get_cls_logins0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 400/*viewAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 400/*viewAlerts*/);
}
}
before () : (call(* *.goodLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_logins0.lock){

_cls_logins0 _cls_inst = _cls_logins0._get_cls_logins0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 398/*goodLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 398/*goodLogin*/);
}
}
before () : (call(* *.invalidLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_logins0.lock){

_cls_logins0 _cls_inst = _cls_logins0._get_cls_logins0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 396/*invalidLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 396/*invalidLogin*/);
}
}
before () : (call(* *.logout(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_logins0.lock){

_cls_logins0 _cls_inst = _cls_logins0._get_cls_logins0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 402/*logout*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 402/*logout*/);
}
}
}