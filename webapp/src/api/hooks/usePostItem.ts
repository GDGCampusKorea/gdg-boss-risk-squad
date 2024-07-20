import { UseMutationResult, useMutation } from "@tanstack/react-query";
import { fetchInstance } from "../instance";
import { AxiosResponse } from "axios";
import { ITEM_LIST_URL, ItemListResponse } from "./useGetItemList";

export interface NewItem {
  itemId: string;
  price: number;
  title: string;
  isInPerson: boolean;
  quantity: number;
  desc: string;
}

export const postItem = async (newItem: NewItem) => {
  const { data } = await fetchInstance().post<NewItem, AxiosResponse<NewItem>>(
    ITEM_LIST_URL,
    newItem,
    {
      headers: {
        "Content-Type": "application/json",
      },
    },
  );

  return data;
};

export const usePostListItem = (): UseMutationResult<
  NewItem,
  Error,
  NewItem,
  unknown
> => {
  return useMutation({
    mutationFn: (newItem: NewItem) => postItem(newItem),
  });
};
