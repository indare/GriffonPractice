package griffon

import groovy.beans.Bindable

class GriffonModel {
   // @Bindable String propName
    @Bindable String function

    @Bindable double from
    @Bindable double to
    @Bindable double min
    @Bindable double max

}