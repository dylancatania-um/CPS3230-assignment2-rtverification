package aspects;

import larva.*;
public aspect _asp_alerts0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_alerts0.initialize();
}
}
before () : (call(* *.viewAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_alerts0.lock){

_cls_alerts0 _cls_inst = _cls_alerts0._get_cls_alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 314/*viewAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 314/*viewAlerts*/);
}
}
before () : (call(* *.createAlert(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_alerts0.lock){

_cls_alerts0 _cls_inst = _cls_alerts0._get_cls_alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 316/*createAlert*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 316/*createAlert*/);
}
}
before () : (call(* *.createAlertInvalid(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_alerts0.lock){

_cls_alerts0 _cls_inst = _cls_alerts0._get_cls_alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 318/*createAlertInvalid*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 318/*createAlertInvalid*/);
}
}
before () : (call(* *.deleteAlertsInvalid(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_alerts0.lock){

_cls_alerts0 _cls_inst = _cls_alerts0._get_cls_alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 322/*deleteAlertsInvalid*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 322/*deleteAlertsInvalid*/);
}
}
before () : (call(* *.deleteAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_alerts0.lock){

_cls_alerts0 _cls_inst = _cls_alerts0._get_cls_alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 320/*deleteAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 320/*deleteAlerts*/);
}
}
}