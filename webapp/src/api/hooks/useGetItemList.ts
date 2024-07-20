import { useQuery } from "@tanstack/react-query";
import { fetchInstance } from "../instance";
import { AxiosResponse } from "axios";
import { itemListMockResponse } from "../msw/itemList";

export const ITEM_LIST_URL = "item-lists";

export type ItemListResponse = typeof itemListMockResponse;

export const getItemList = async () => {
  const { data } = await fetchInstance().get<
    undefined,
    AxiosResponse<ItemListResponse>
  >(ITEM_LIST_URL);

  return data;
};

export const useItemList = () => {
  const { isPending, error, data, isFetching } = useQuery({
    queryKey: ["itemList"],
    queryFn: () => getItemList(),
  });

  return { data, isPending, error, isFetching };
};
