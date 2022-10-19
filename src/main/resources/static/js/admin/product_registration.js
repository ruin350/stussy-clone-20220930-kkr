class ProductMst{
    // # = private 
    #category;
    #name;
    #price;
    #simpleInfo;
    #detailInfo;
    #optionInfo;
    #managementInfo;
    #shippingInfo;
    
    constructor(category,name,price,simpleInfo,detailInfo,optionInfo,managementInfo,shippingInfo){
        this.#category = category;
        this.#name = name;
        this.#price = price;
        this.#simpleInfo = simpleInfo;
        this.#detailInfo = detailInfo;
        this.#optionInfo = optionInfo;
        this.#managementInfo = managementInfo;
        this.#shippingInfo = shippingInfo;

    }

    getCategory(){return this.#category;}
    setCategory(category){this.#category = category;}
    
    getName(){return this.#name;}
    setName(name){this.#name = name;}

    getPrice(){return this.#price;}
    setPrice(price){this.#price = price;}

    getSimpleInfo(){return this.#simpleInfo;}
    setSimpleInfo(simpleInfo){this.#simpleInfo = simpleInfo;}

    getDetailInfo(){return this.#detailInfo;}
    setDetailInfo(detailInfo){this.#detailInfo = detailInfo;}

    getOptionInfo(){return this.#optionInfo;}
    setOptionInfo(optionInfo){this.#optionInfo = optionInfo;}

    getManagementInfo(){return this.#managementInfo;}
    setManagementInfo(managementInfo){this.#managementInfo = managementInfo;}

    getShippingInfo(){return this.#shippingInfo;}
    setShippingInfo(shippingInfo){this.#shippingInfo = shippingInfo;}

    getObject(){
        const obj ={
            category: this.#category,
            name: this.#name,
            price: this.#price,
            simpleInfo: this.#simpleInfo,
            detailInfo: this.#detailInfo,
            optionInfo: this.#optionInfo,
            managementInfo: this.#managementInfo,
            shippingInfo: this.#shippingInfo
        }
        return obj;
    }
}
class RegisterApi{
    createProductRequest(productMst){
        let responsResult = null;

        $.ajax({
            async: false,
            type: "post",
            url: "/api/admin/product",
            contentType: "application/json",
            data: JSON.stringify(productMst),
            dataType: "json",
            success: (response) => {
                responsResult = response.data;
            },
            error: (error) => {
                console.log(error);
            }
        });
        return responsResult;
    }
}
class RegisterEventService{
    #categorySelectObj;
    #nameInputObj;
    #priceInputObj;
    #registButtonObj;
    #infoTextareaObjs;

    constructor(){
        this.#categorySelectObj = document.querySelectorAll(".product-inputs")[0];
        this.#nameInputObj = document.querySelectorAll(".product-inputs")[1];
        this.#priceInputObj = document.querySelectorAll(".product-inputs")[2];
        this.#registButtonObj = document.querySelector(".regist-button");
        this.#infoTextareaObjs = document.querySelectorAll(".product-inputs");

        this.init();

        this.addCategorySelectEvent();
        this.addNameInputEvent();
        this.addPriceInputEvent();
        this.addRegistButtonEvent();
    }

    // disabled 비활성화
    init(){
        this.#nameInputObj.disabled = true;
        this.#priceInputObj.disabled = true;
        this.#registButtonObj.disabled = true;
    }

    // 카테고리 onchange 셀렉트값이 변경될때 함수호출
    addCategorySelectEvent() {
        this.#categorySelectObj.onchange = () => {
            if(this.#categorySelectObj.value != "none") {
                this.#nameInputObj.disabled = false;
            }else {
                this.#nameInputObj.disabled = true;
            }
        }
    }

    // 상품명 onkeyup 사용자가 키를 눌렀다가 땟을때
    addNameInputEvent() {
        this.#nameInputObj.onkeyup = () => {
            if(this.#nameInputObj.value.length != 0) {
                this.#priceInputObj.disabled = false;
            }else {
                this.#priceInputObj.disabled = true;
            }
        }
    }
    
    // 가격
    addPriceInputEvent() {
        this.#priceInputObj.onkeyup = () => {
            const registInfo = document.querySelector(".regist-info");

            if(this.#priceInputObj.value.length != 0) {
                this.#registButtonObj.disabled = false;
                registInfo.classList.remove("regist-info-invisible");

            }else {
                this.#registButtonObj.disabled = true;
                registInfo.classList.add("regist-info-invisible");

            }
        }
    }
    // 버튼클릭시 RegisterObj, info의 value를 전달 onclick 클릭했을때
    addRegistButtonEvent() {
        this.#registButtonObj.onclick = () => {
            const category = this.#categorySelectObj.value;
            const name = this.#nameInputObj.value;
            const price = this.#priceInputObj.value;
            const simpleInfo = this.#infoTextareaObjs[3].value;
            const detailInfo = this.#infoTextareaObjs[4].value;
            const optionInfo = this.#infoTextareaObjs[5].value;
            const managementInfo = this.#infoTextareaObjs[6].value;
            const shippingInfo = this.#infoTextareaObjs[7].value;

            const productMst = new ProductMst(
                category, name, price, simpleInfo, detailInfo, 
                optionInfo, managementInfo, shippingInfo);

            console.log(productMst.getObject());

            const registerApi = new RegisterApi();
            registerApi.createProductRequest(productMst.getObject());
        }
    }
}

class RegisterService{
    static #instance = null;

    // 생성자
    constructor(){
    }
    
    static getInstance(){
        if(this.#instance == null){
            this.#instance = new RegisterService();
        }
        return this.#instance;
    }
    // 메서드
    loadRegister(){
        
    }
    
    setRegisterHeaderEvent(){
        new RegisterEventService();
        
    }
}

// 호출
window.onload = () =>{
    RegisterService.getInstance().setRegisterHeaderEvent();
}
