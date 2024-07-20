import {
  HttpResponse as mswHttpResponse,
  http as mswHttp,
  HttpHandler,
} from "msw";
import { ITEM_LIST_URL, ItemListResponse } from "@api/hooks/useGetItemList";
import { API_ENDPOINT } from "../instance";

export const itemListMockResponse = [
  {
    itemId: "02542470",
    price: 50000,
    title: "중고 카메라",
    isInPerson: true,
    quantity: 1,
    desc: "돈이 없어서..ㅠㅠ 카메라 사고 싶은 마음에 바카디 술 대신 판매합니다",
  },
  {
    itemId: "11257089",
    price: 30000,
    title: "중고 자전거",
    isInPerson: true,
    quantity: 1,
    desc: "편의점에서 얻은 자전거인데 필요 없어서 판매합니다",
  },
  {
    itemId: "08407137",
    price: 12000,
    title: "중고 영화 DVD 세트",
    isInPerson: true,
    quantity: 5,
    desc: "영화관 직원 시절에 받은 DVD 세트 판매합니다",
  },
  {
    itemId: "32979422",
    price: 10000,
    title: "중고 책 세트",
    isInPerson: true,
    quantity: 10,
    desc: "도서관 정리 중 발견한 책들 판매합니다",
  },
  {
    itemId: "37998208",
    price: 20000,
    title: "중고 식기 세트",
    isInPerson: true,
    quantity: 1,
    desc: "레스토랑에서 사용한 식기 세트 판매합니다",
  },
  {
    itemId: "01695878",
    price: 15000,
    title: "중고 주방용품",
    isInPerson: true,
    quantity: 1,
    desc: "식품 매장에서 정리한 주방용품 판매합니다",
  },
  {
    itemId: "09792471",
    price: 70000,
    title: "중고 헬스 기구",
    isInPerson: true,
    quantity: 1,
    desc: "피트니스 트레이너 시절 사용한 헬스 기구 판매합니다",
  },
  {
    itemId: "23939055",
    price: 25000,
    title: "중고 의류",
    isInPerson: true,
    quantity: 3,
    desc: "백화점에서 구매한 의류 판매합니다",
  },
  {
    itemId: "94689745",
    price: 8000,
    title: "중고 포장재",
    isInPerson: true,
    quantity: 50,
    desc: "물류 센터에서 사용한 포장재 판매합니다",
  },
  {
    itemId: "49322156",
    price: 50000,
    title: "중고 호텔 용품",
    isInPerson: true,
    quantity: 1,
    desc: "호텔에서 사용한 프런트 데스크 용품 판매합니다",
  },
];

const itemListGet = (statusCode: number, response: ItemListResponse) =>
  mswHttp.get(`${API_ENDPOINT}/${ITEM_LIST_URL}`, () => {
    // ...and respond to them using this JSON response.
    return mswHttpResponse.json(response, { status: statusCode });
  });

export const itemListHandlers: HttpHandler[] = [
  itemListGet(200, itemListMockResponse),
];
