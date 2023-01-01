package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_logins0 implements _callable{

public static PrintWriter pw; 
public static _cls_logins0 root;

public static LinkedHashMap<_cls_logins0,_cls_logins0> _cls_logins0_instances = new LinkedHashMap<_cls_logins0,_cls_logins0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\Dylan\\workspace\\CPS3230-assignment2-rtverification/src/output_logins.txt");

root = new _cls_logins0();
_cls_logins0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_logins0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_logins0() {
}

public void initialisation() {
}

public static _cls_logins0 _get_cls_logins0_inst() { synchronized(_cls_logins0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_logins0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_logins0_instances){
_performLogic_loginsProperty(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_logins0[] a = new _cls_logins0[1];
synchronized(_cls_logins0_instances){
a = _cls_logins0_instances.keySet().toArray(a);}
for (_cls_logins0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_logins0_instances){
_cls_logins0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_loginsProperty = 114;

public void _performLogic_loginsProperty(String _info, int... _event) {

_cls_logins0.pw.println("[loginsProperty]AUTOMATON::> loginsProperty("+") STATE::>"+ _string_loginsProperty(_state_id_loginsProperty, 0));
_cls_logins0.pw.flush();

if (0==1){}
else if (_state_id_loginsProperty==113){
		if (1==0){}
		else if ((_occurredEvent(_event,402/*logout*/))){
		_cls_logins0.pw .println ("Logged out");

		_state_id_loginsProperty = 114;//moving to state loginPage
		_goto_loginsProperty(_info);
		}
}
else if (_state_id_loginsProperty==114){
		if (1==0){}
		else if ((_occurredEvent(_event,396/*invalidLogin*/))){
		_cls_logins0.pw .println ("Login failed. Invalid Id");

		_state_id_loginsProperty = 114;//moving to state loginPage
		_goto_loginsProperty(_info);
		}
		else if ((_occurredEvent(_event,398/*goodLogin*/))){
		_cls_logins0.pw .println ("Successfully logged in");

		_state_id_loginsProperty = 113;//moving to state alertsPage
		_goto_loginsProperty(_info);
		}
}
}

public void _goto_loginsProperty(String _info){
_cls_logins0.pw.println("[loginsProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_loginsProperty(_state_id_loginsProperty, 1));
_cls_logins0.pw.flush();
}

public String _string_loginsProperty(int _state_id, int _mode){
switch(_state_id){
case 113: if (_mode == 0) return "alertsPage"; else return "alertsPage";
case 114: if (_mode == 0) return "loginPage"; else return "loginPage";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}