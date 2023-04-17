<#-- @ftlvariable name="error" type="agh.models.Error" -->
<#import "index.ftl" as layout />
<@layout.header>
    <div>
        <h1>
            Error : ${error.text} Code : ${error.code}
        </h1>
    </div>
</@layout.header>