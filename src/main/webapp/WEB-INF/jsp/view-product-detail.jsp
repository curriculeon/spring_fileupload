<body>
    <div id="global">
        <h4>The product has been saved.<h4>
        <h5>Details:</h5>
        Product Name: ${product.name}<br />
        Description: ${product.description}<br />
        <p>The following files were uploaded successfully:</p>
        <ol>
            <c:forEach items="${product.images}" var="image">
                <li>
                    ${image.originalFilename}
                    <img width="100" src="${pageContext.request.contextPath}/fileuploads/${image.originalFilename}"/>
                </li>
            </c:forEach>
        </ol>
    </div>
</body>