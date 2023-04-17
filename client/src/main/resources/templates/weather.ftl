<#-- @ftlvariable name="weather" type="agh.models.SimpleWeatherData" -->
<#import "index.ftl" as layout />
<@layout.header>
    <div>
        <h3>
            Max : ${weather.max}
        </h3>
    </div>
    <div>
        <h3>
            Min : ${weather.min}
        </h3>
    </div>
    <div>
        <h3>
            Mean : ${weather.mean}
        </h3>
    </div>
    <#list weather.list as item>
        <div>
            <h3>
                ${item.text} : ${item.value}
            </h3>
        </div>
    </#list>
</@layout.header>