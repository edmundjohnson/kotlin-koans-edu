package properties.delegates_how_it_works

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class D {
    var date: MyDate by EffectiveDate()
}

/*<answer>*/class EffectiveDate<R> : ReadWriteProperty<R, MyDate> {

    var timeInMillis: Long? = null

    override fun getValue(thisRef: R, property: KProperty<*>): MyDate {
        /*<taskWindow>*/return timeInMillis!!.toDate()/*</taskWindow>*/
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: MyDate) {
        /*<taskWindow>*/timeInMillis = value.toMillis()/*</taskWindow>*/
    }
}
/*</answer>*/