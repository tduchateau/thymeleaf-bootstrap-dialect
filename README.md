Thymeleaf Bootstrap dialect
===========================

This is a draft of a Twitter's Bootstrap Thymeleaf dialect.

For now, it only allows to generate Nav (tabs and pills) using custom Thymeleaf tags.

Requirements
------------

 - Java 6
 - Thymeleaf 2.0.15


Installation
------------

TODO

Usage
-----

### Nav tabs

    <bootstrap:nav type="tabs">
        <tab id="firstId" label="First tab" active="true">
            any content here : plain text, HTML tags (even if they need to be processed by Thymeleaf !)
        </tab>
        <tab id="secondId" label="Second tab">
            any content here too !
        </tab>
    </bootstra:nav>

### Nav pills

Just replace the <code>type</code> attribute value by <tt>pills</tt> !

    <bootstrap:nav type="pills">



[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/tduchateau/thymeleaf-bootstrap-dialect/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

