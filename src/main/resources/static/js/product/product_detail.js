class ProductApi {
    static #instance = null;
    static getInstance(){
        if(this.#instance == null){
            this.#instance = new ProductApi();
        }
        return this.#instance;
    }

    getProductData(){
        let responseData = null;
        const url = location.href;
        const pdtId = url.substring(url.lastIndexOf("/") + 1 );
        $.ajax({
            async: false,
            type: "get",
            url: "/api/product/" + pdtId,
            dataType: "json",
            success: response => {
                responseData = response.data;
            },
            error: error =>{
                console.log(error);
            }
        });

        return responseData;
    }
}

window.onload = () => {
    console.log(ProductApi.getInstance().getProductData());
}