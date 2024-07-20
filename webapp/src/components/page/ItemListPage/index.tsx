import { useFlow } from "@/lib/stackflow";
import { NewItem, usePostListItem } from "@api/hooks/usePostItem";
import { Text } from "@components/common/atoms/Text";
import AsyncBoundary from "@components/template/AsyncBoundary";
import { AppScreen } from "@stackflow/plugin-basic-ui";

export const ItemListPage = () => {
  const { push } = useFlow();
  const mutation = usePostListItem();

  const newItem: NewItem = {
    itemId: "new-item-id", // 예시 값
    price: 1000,
    title: "New Item",
    isInPerson: true,
    quantity: 1,
    desc: "This is a new item",
  };
  const handlePostItem = (item: NewItem) => {
    return mutation.mutate(item, {
      onSuccess: (data) => {
        console.log(data);
      },
    });
  };

  return (
    <AsyncBoundary>
      <AppScreen>
        <Text onClick={() => push("ItemUploadPage", {})}>상품 올리기</Text>
        <Text onClick={() => push("ItemDetailPage", {})}>세부 페이지</Text>
        <Text onClick={() => handlePostItem(newItem)}>세부 페이지</Text>
      </AppScreen>
    </AsyncBoundary>
  );
};
